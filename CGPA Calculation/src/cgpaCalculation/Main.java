package cgpaCalculation;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String CHOICE_CIE;
    public static String CHOICE_GRADE;
    public static void display(ArrayList<Float> list, Integer numOfSub, Integer colSize){
        Integer count =0;
        for(Float mark : list){
            if(count%colSize==0){                     // Prints the table design.
                System.out.print("\n");
                for(Integer i=1;i <= colSize;i++)System.out.print("-------");
                System.out.print("\n|");
            }
            System.out.print(" "+mark+" |");
            count++;
        }
        System.out.println("");
        for(Integer i=1;i <= colSize;i++)System.out.print("-------");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("ENTER THE NUMBER OF SUBJECTS FOR THIS SEMESTER BELOW:");
        Integer numOfSub = s.nextInt();
        StudentMarksContainer m1 = new StudentMarksContainer(numOfSub);
        System.out.println("DO YOU WANT TO CALCULATE CIE MARKS? [Yes/No]:");
        CHOICE_CIE = s.next();
        if(CHOICE_CIE.toLowerCase().equals("no")){
            System.out.println("----ENTER YOUR FINAL CIE MARKS BELOW---- ");
            m1.readCIE();
        }

        else {
            System.out.println("----ENTER CIE MARKS FOR 3 OF THE INTERNALS, BEST TWO WILL BE CONSIDERED. ENTER 0 IF YOU HAVEN'T ATTENDED THE EXAM. ---- ");
            m1.readCIE();
            System.out.println("----ENTER YOUR AAT MARKS TO CALCULATE YOUR FINALISED CIE MARKS----");
        }
        //display(m1.CIEMarks, numOfSub, m1.tests);

        //Testing functions
        ArrayList<Float> fm = new ArrayList<Float>();
        ArrayList<Character> g = new ArrayList<Character>();
        ArrayList<Integer> gp = new ArrayList<Integer>();
        System.out.println("enter see:");
        m1.readSEE();
        CalculateSGPA c1 = new CalculateSGPA();
        fm=c1.calculateFinalMarks(m1.CIEMarks, m1.SEEMarks, m1.numOfSub);
        System.out.println(fm);
        g = c1.AssignGrades(fm);
        System.out.println(g);
        gp = c1.AssignGradePoints(g);
        System.out.println(gp);


    }
}

