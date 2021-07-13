package cgpaCalculation;

import java.util.*;
import java.io.*;

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

                int index=0;
                for (int i =0;i<spaceWidth;i++){
                    if(index<=(sName.length()-1)){
                        System.out.print(charName[index]);

                        if(i<=(sName.length()-1)) {
                            if (charName[index] == '\n') i = -1;
                        }
                        index++;
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

    public static void main(String[] args)throws FileNotFoundException {
        DataContainer D = new DataContainer();
        D.initializeData();
        Scanner s = new Scanner(System.in);
        System.out.println("ENTER YOUR NAME:");
        String name=s.nextLine();
        System.out.println("ENTER YOUR USN:");
        String usn=s.nextLine();
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

        PrintStream printStream = new PrintStream("ConsoleOutputFile.txt");
        System.setOut(printStream);
        
        System.out.println("\nName : "+name);
        System.out.println("USN : "+usn);

        System.out.println("\n\n---CIE MARKS---");
        display(S.CIEMarks,S.numOfSub, 1, S, 60);
        System.out.println("---SEE MARKS---");
        display(S.SEEMarks, S.numOfSub, 1, S, 60);
        System.out.println("SEMESTER END GRADE POINT AVERAGE (SGPA): "+ S.sgpa);


        
        PrintStream consoleStream = new PrintStream(new FileOutputStream(FileDescriptor.out));
        System.setOut(consoleStream);

        File myObj = new File("ConsoleOutputFile.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();

        
        
        
/*RECOMMENDATIONS*/
        System.out.println("-----S.G.P.A RECOMMENDATIONS-----\n");
        System.out.println("------YOU JUST HAVE TO ENTER YOUR PREVIOUS SEMESTER C.G.P.A AND YOUR TARGET C.G.P.A. THE PROGRAM RECOMMENDS SEVERAL PLANS TO ACHIEVE YOUR TARGET C.G.P.A.------\n ");
   Scanner in = new Scanner(System.in);
   roundoff r=new roundoff();
   int c_sem,l_sem,flag=0;
   float c_sgpa,t_sgpa,p_sgpa,prevsum=0;
   c_sem= semester;
   l_sem = 8-c_sem;
   float prev_sem;
   /*for(int i=0;i<c_sem-1;i++){
   System.out.println("enter sem-"+(i+1)+" sgpa : ");
   prev_sem[i]=in.nextFloat();
   }*/
   System.out.println("ENTER YOUR SEMESTER "+(semester-1)+" C.G.P.A : ");
   prev_sem=in.nextFloat();
   prev_sem=r.round(prev_sem);
   if(prev_sem==0.0f) System.exit(0);
   //System.out.println("SEMESTER "+(semester-1)+" C.G.P.A : "+prev_sem);
   c_sgpa=r.round(S.sgpa);
   System.out.println("SEMESTER "+(semester)+" C.G.P.A : "+c_sgpa);
   System.out.println("ENTER YOUR TARGET C.G.P.A : ");
   t_sgpa=in.nextFloat();
   
   prevsum=prev_sem*(c_sem-1);
   prevsum+=c_sgpa;
   p_sgpa=((t_sgpa*8)-prevsum);
        
        //System.out.println("p_sgpa\n"+p_sgpa);
        
        
        ArrayList<Float> numbers = new ArrayList<Float>(Arrays.asList(5.0f,5.5f,6.0f,6.5f,7.0f,7.5f,8.0f,8.5f,9.0f,9.5f,10.0f));
        LinkedHashSet<Float> targets = new LinkedHashSet<Float>() {{
            add(p_sgpa);
        }};
        
        
      PrintStream print_Stream = new PrintStream("Plan.txt");
      System.setOut(print_Stream);

        
        
        System.out.println("## THE DEVISED PLANS");
        for (Float target: targets) {
            Combinations combinations = new Combinations(numbers, target, true);
            combinations.calculateCombinations();
            int count=0;
            for (String solution: combinations.getCombinations()) {
            //System.out.println(solution);
                int l=solution.length();
      ArrayList<String> arr_new = new ArrayList<String>();
      float arr_new_sum=0.0f;
      char m,n;
      for(int x=0;x<l;x=x+3){
      m=solution.charAt(x);
      n=solution.charAt(x+1);
      if(m=='1' && n=='0'){
      arr_new.add("10.0");
      x++;
      }
      else{
      String word= new String();
      //for(int i=0;i<charList.size();i=i+3){
      for(int j=x;j<x+3;j++){
      word= word+ solution.charAt(j);}
      arr_new.add(word);
      }
      }
      //System.out.print(arr_new);
      for(int z=0;z<arr_new.size();z++){arr_new_sum=arr_new_sum + (Float.valueOf(arr_new.get(z)));}
      //System.out.println("arr_new_sum : "+arr_new_sum);
      if((arr_new.size() == l_sem) && (arr_new_sum == p_sgpa)){
      flag++;
      System.out.println("\nPLAN "+(++count)+" -> ");
      int sem=c_sem;
      for(int pos=0;pos<arr_new.size();pos++){
      System.out.print("SEMESTER "+(++sem)+": "+arr_new.get(pos)+"\n");}
      }
      else if((arr_new.size()==0) || (arr_new.size()>l_sem)){flag=0;}
      }
      }
      if(flag==0){System.out.println("SORRY, THERE ARE NO POSSIBLE PLANS TO ACHIEVE "+t_sgpa+" C.G.P.A :(");}

       /* System.out.println("## each element can appear only once");
        for (Integer target: targets) {
            Combinations combinations = new Combinations(numbers, target, false);
            combinations.calculateCombinations();
            for (String solution: combinations.getCombinations()) {
                System.out.println(solution);
            }
        }*/
        PrintStream console_Stream = new PrintStream(new FileOutputStream(FileDescriptor.out));
        System.setOut(console_Stream);

        File my_Obj = new File("Plan.txt");
      Scanner my_Reader = new Scanner(my_Obj);
      while (my_Reader.hasNextLine()) {
        String data = my_Reader.nextLine();
        System.out.println(data);
      }
      my_Reader.close();

    }

    }

