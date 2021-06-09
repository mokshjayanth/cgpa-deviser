package cgpaCalculation;

import java.util.ArrayList;

public class CalculateSGPA {

    ArrayList<Float> calculateFinalMarks(ArrayList<Float> cieMarks, ArrayList<Float> seeMarks, Integer numOfSub) {
        ArrayList<Float> finalMarks = new ArrayList<Float>();
        for (Integer i = 0; i < numOfSub; i++) {
            finalMarks.add(cieMarks.get(i) + (seeMarks.get(i) / 2));
        }
        return finalMarks;
    }

    ArrayList<Character> AssignGrades(ArrayList<Float> finalMarks) {
        ArrayList<Character> grades = new ArrayList<Character>();
        for (Float mark : finalMarks) {
            if (mark >= 90) grades.add('S');
            else if (80 <= mark && mark < 90) grades.add('A');
            else if (70 <= mark && mark < 80) grades.add('B');
            else if (60 <= mark && mark < 70) grades.add('C');
            else if (50 <= mark && mark < 60) grades.add('D');
            else if (40 <= mark && mark < 50) grades.add('E');
            else grades.add('F');
        }

        return grades;

    }

    ArrayList<Integer> AssignGradePoints(ArrayList<Character> grades) {
        ArrayList<Integer> gradePoints = new ArrayList<Integer>();
        for (Character grade : grades) {
            switch (grade) {
                case 'S':
                    gradePoints.add(10);
                    break;
                case 'A':
                    gradePoints.add(9);
                    break;
                case 'B':
                    gradePoints.add(8);
                    break;
                case 'C':
                    gradePoints.add(7);
                    break;
                case 'D':
                    gradePoints.add(6);
                    break;
                case 'E':
                    gradePoints.add(4);
                    break;
                case 'F':
                    gradePoints.add(0);
                    break;
            }
        }
        return gradePoints;
    }
}
