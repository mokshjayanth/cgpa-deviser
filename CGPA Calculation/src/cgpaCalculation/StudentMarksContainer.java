package cgpaCalculation;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedHashMap;

class StudentMarksContainer {
    Scanner s = new Scanner(System.in);
    Integer semester;
    Integer numOfSub;
    //Integer tests;              //No. of the tests the student has taken in CIE
    Float sgpa;
    public LinkedHashMap<String, Integer> subjects = new LinkedHashMap<String, Integer>();
    public ArrayList<Float> CIEMarks = new ArrayList<Float>();
    public ArrayList <Float> SEEMarks = new ArrayList<Float>();
    //public ArrayList <Float> AAT = new ArrayList<Float>();
    public ArrayList <Float> finalMarks = new ArrayList<Float>();
    public ArrayList<Integer> gradePoints = new ArrayList<Integer>();
    public ArrayList<Character> grades = new ArrayList<Character>();

    StudentMarksContainer(Integer n){
        this.semester = n;
    }

    void assignSubjects(DataContainer D){
        switch (semester){
            case 1:
                numOfSub = D.sem1.size();
                subjects = D.sem1;
                break;
            case 2:
                numOfSub = D.sem2.size();
                subjects = D.sem2;
                break;
            case 3:
                numOfSub = D.sem3.size();
                subjects = D.sem3;
                break;
            case 4:
                numOfSub = D.sem4.size();
                subjects = D.sem4;
                break;
            case 5:
                numOfSub = D.sem5.size();
                subjects = D.sem5;
                break;
            case 6:
                numOfSub = D.sem6.size();
                subjects = D.sem6;
                break;
            case 7:
                numOfSub = D.sem7.size();
                subjects = D.sem7;
                break;
            case 8:
                numOfSub = D.sem8.size();
                subjects = D.sem8;
                break;
        }
    }
    void readCIE(){
        //if(Main.CHOICE_CIE.toLowerCase().equals("no")) tests = 1;
        //else tests=3;
        for(String subject : subjects.keySet()){
            System.out.println("ENTER THE  CIE MARKS FOR SUBJECT " + subject+":");
            for(int j=0;j<1;j++)
                CIEMarks.add(s.nextFloat());
        }
    }
    void readSEE(){
        System.out.println("ENTER SEE MARKS BELOW:");
        for(String subject : subjects.keySet()){
            System.out.println("ENTER THE  SEE MARKS FOR SUBJECT "+subject+":" );
            SEEMarks.add(s.nextFloat());
        }
    }

    /*
    void readAAT(){
        System.out.println("ENTER AAT MARKS FOR EACH SUBJECT BELOW:");
        for(String subject : subjects.keySet()){
            System.out.println("ENTER THE AAT MARKS FOR SUBJECT "+subject+":" );
            SEEMarks.add(s.nextFloat());
        }
    }
    */
}