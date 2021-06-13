package cgpaCalculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    //public static String CHOICE_CIE;
    //public static String CHOICE_GRADE;
    public static void display(ArrayList<Float> list, Integer numOfSub, Integer colSize, StudentMarksContainer S, int spaceWidth){
        Integer count =0;Integer j =0;
        Set<String> keys = S.subjects.keySet();
        List<String> subjectKeys = new ArrayList<String>(keys);             //Storing the names of the subjects in an arrayList
        for(Float mark : list){
            if(count%colSize==0){                     // Prints the table design.
                System.out.print("\n");
                for (Integer i =0;i<spaceWidth;i++) System.out.print(" ");
                for(Integer i=1;i <= colSize;i++)System.out.print("--------");
                System.out.print("\n");      //----*

                String sName = subjectKeys.get(j);              //Get the name of the subject by index
                char[] charName = sName.toCharArray();          //Convert String to char Array

                for (Integer i =0;i<spaceWidth;i++){
                    if(i<=(sName.length()-1)){
                        System.out.print(charName[i]);
                    }
                    else System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.print(" "+mark+" |");
            count++;j++;
        }
        //Table's footer
        System.out.print("\n");
        for (Integer i =0;i<spaceWidth;i++) System.out.print(" ");
        for(Integer i=1;i <= colSize;i++)System.out.print("--------");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        DataContainer D = new DataContainer();
        D.initializeData();
        Scanner s = new Scanner(System.in);
        System.out.println("ENTER YOUR CURRENT SEMESTER:");
        Integer semester = s.nextInt();
        StudentMarksContainer S = new StudentMarksContainer(semester);
        S.assignSubjects(D);

        /*System.out.println("DO YOU WANT TO CALCULATE CIE MARKS? [Yes/No]:");
        CHOICE_CIE = s.next();
        if(CHOICE_CIE.toLowerCase().equals("no")){
            System.out.println("----ENTER YOUR FINAL CIE MARKS BELOW---- ");
            S.readCIE();
        }
        */
        //else {
            System.out.println("----ENTER FINALIZED CIE MARKS FOR SEMESTER "+S.semester+" ---- ");
            S.readCIE();
        //}

        System.out.println("---ENTER YOUR SEE MARKS FOR SEMESTER "+S.semester+" ----");
        S.readSEE();
        CalculateSGPA c1 = new CalculateSGPA();
        S.finalMarks = c1.calculateFinalMarks(S);
        S.grades = c1.AssignGrades(S);
        S.gradePoints = c1.AssignGradePoints(S);
        S.sgpa = c1.calculate(S);


        System.out.println("---CIE MARKS---");
        display(S.CIEMarks,S.numOfSub, 1, S, 60);
        System.out.println("---SEE MARKS---");
        display(S.SEEMarks, S.numOfSub, 1, S, 60);
        System.out.println("SEMESTER END GRADE POINT AVERAGE (SGPA): "+ S.sgpa);






    }
}

