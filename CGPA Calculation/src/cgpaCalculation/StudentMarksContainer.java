package cgpaCalculation;

import java.util.ArrayList;
import java.util.Scanner;

class StudentMarksContainer {
    Scanner s = new Scanner(System.in);
    Integer numOfSub;
    Integer tests;
    public ArrayList<Float> CIEMarks = new ArrayList<Float>();
    public ArrayList <Float> SEEMarks = new ArrayList<Float>();
    public ArrayList <Float> AAT = new ArrayList<Float>();

    StudentMarksContainer(Integer n){
        this.numOfSub = n;
    }
    void readCIE(){
        if(Main.CHOICE_CIE.toLowerCase().equals("no")) tests = 1;
        else tests=3;
        for(int i=0;i<numOfSub;i++){
            System.out.println("ENTER THE  CIE MARKS FOR SUBJECT"+ (i+1)+" FOR ALL OF  THE THREE EXAMS IN CHRONOLOGICAL ORDER: ");
            for(int j=0;j<tests;j++)
                CIEMarks.add(s.nextFloat());
        }
    }
    void readSEE(){
        System.out.println("ENTER SEE MARKS BELOW:");
        for(int i=0;i<numOfSub;i++){
            System.out.println("ENTER THE  SEE MARKS FOR SUBJECT"+ (i+1)+":" );
            SEEMarks.add(s.nextFloat());
        }
    }
    void readAAT(){
        System.out.println("ENTER AAT MARKS FOR EACH SUBJECT BELOW:");
        for(int i=0;i<numOfSub;i++){
            System.out.println("ENTER THE AAT MARKS FOR SUBJECT"+ (i+1)+":" );
            SEEMarks.add(s.nextFloat());
        }
    }

}
