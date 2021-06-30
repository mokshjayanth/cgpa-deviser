package cgpaCalculation;
public class roundoff{
   public static float round(float x){
   if((x < 5.5f)&&(x >= 5.0f)){return 5.0f;}
   else if((x < 6.0f)&&(x >= 5.5f)){return 5.5f;}
   else if((x < 6.5f)&&(x >= 6.0f)){return 6.0f;}
   else if((x < 7.0f)&&(x >= 6.5f)){return 6.5f;}
   else if((x < 7.5f)&&(x >= 7.0f)){return 7.0f;}
   else if((x < 8.0f)&&(x >= 7.5f)){return 7.5f;}
   else if((x < 8.5f)&&(x >= 8.0f)){return 8.0f;}
   else if((x < 9.0f)&&(x >= 8.5f)){return 8.5f;}
   else if((x < 9.5f)&&(x >= 9.0f)){return 9.0f;}
   else if((x < 10.0f)&&(x >= 9.5f)){return 9.5f;}
   else if(x == 10.0f){return 10.0f;}
   else if((x < 5.0f)||(x >= 10.0f)){System.out.println("Invalid !!");}
   return 0.0f;
}
}
