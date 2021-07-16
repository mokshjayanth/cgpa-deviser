package cgpaCalculation;
import java.util.*;
import java.io.*;


    public class Combinations {
        private boolean allowRepetitions;
        private int[] repetitions;
        private ArrayList<Float> numbers;
        private Float target;
        private Float sum;
        private boolean hasNext;
        private Set<String> combinations;


        
        public Combinations(ArrayList<Float> numbers, Float target) {
            this(numbers, target, true);
        }


        public Combinations(ArrayList<Float> numbers, Float target, boolean allowRepetitions) {
            this.allowRepetitions = allowRepetitions;
            if (this.allowRepetitions) {
                Set<Float> numbersSet = new HashSet<>(numbers);
                this.numbers = new ArrayList<>(numbersSet);
            } else {
                this.numbers = numbers;
            }
            this.numbers.removeAll(Arrays.asList(0));
            Collections.sort(this.numbers);

            this.target = target;
            this.repetitions = new int[this.numbers.size()];
            this.combinations = new LinkedHashSet<>();

            this.sum = 0.0f;
            if (this.repetitions.length > 0)
                this.hasNext = true;
            else
                this.hasNext = false;
        }


        private Float calculateSum() {
            this.sum = 0.0f;
            for (int i = 0; i < repetitions.length; ++i) {
                this.sum += repetitions[i] * numbers.get(i);
            }
            return this.sum;
        }


        private void redistribute() {
            for (int i = 1; i < this.repetitions.length; ++i) {
                if (this.repetitions[i - 1] > 1) {
                    this.repetitions[i - 1] = 0;
                    this.repetitions[i] += 1;
                }
            }
            if (this.repetitions[this.repetitions.length - 1] > 1)
                this.repetitions[this.repetitions.length - 1] = 0;
        }


        private Float next() {
            if (this.hasNext && this.repetitions.length > 0) {
                this.repetitions[0] += 1;
                if (!this.allowRepetitions)
                    this.redistribute();
                this.calculateSum();

                for (int i = 0; i < this.repetitions.length && this.sum != 0; ++i) {
                    if (this.sum > this.target) {
                        this.repetitions[i] = 0;
                        if (i + 1 < this.repetitions.length) {
                            this.repetitions[i + 1] += 1;
                            if (!this.allowRepetitions)
                                this.redistribute();
                        }
                        this.calculateSum();
                    }
                }

                if (this.sum.compareTo(0.0f) == 0.0f)
                    this.hasNext = false;
            }
            return this.sum;
        }


        public void calculateCombinations() {
            while (this.hasNext) {
                if (this.next().compareTo(target) == 0)
                    this.combinations.add(this.toString());
            }
        }

        public Set<String> getCombinations() {
            return this.combinations;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < repetitions.length; ++i) {
                for (int j = 0; j < repetitions[i]; ++j) {
                    stringBuilder.append(numbers.get(i));
                }
            }
            return stringBuilder.toString();
        }
        

    }
