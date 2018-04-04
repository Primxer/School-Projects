/*
   Ronnie C. Ripley
   425-623-4844 (text available)
   Program to output a rocket shape that varies from a class constant using nested loops
   Total Hours: 10 hrs
*/
public class drawRocket
{
   final static int CONSTANT = 3;   
   public static void main(String args[])
   {
     drawCone();
     drawLine();
     drawTop();
     drawLine();
     drawBottom();
     drawLine();
     drawCone();
   }
   
   public static void drawCone()
   {
      for(int i=1; i<=CONSTANT*2-1; i++)
      {
         for(int space=CONSTANT*2-1; space>=i-1; space--)
         {
            System.out.print(" ");
         }
         
         for(int fslash=0; fslash<=i-1; fslash++)
         {
            System.out.print("/");
         }
         
         System.out.print("**");
         
         for(int bslash=0; bslash<=i-1; bslash++)
         {
            System.out.print("\\");
         }
         System.out.print("\n");
         
      }
   }
   
   public static void drawBottomHalf()
   {
      
      for(int i=1; i<=CONSTANT; i++)
      {
         System.out.print(" ");
         System.out.print("|");
         
         for(int dot=CONSTANT-1; dot>=i; dot--)
         {
            System.out.print(".");
         }
         
         for(int cone=1; cone<=i; cone++)   
         {
            System.out.print("/\\");
         }
         
         for(int dot1=CONSTANT-1; dot1>=i; dot1--)
         {
            System.out.print(".");
         }
         
         for(int dot1=CONSTANT-1; dot1>=i; dot1--)
         {
            System.out.print(".");
         }
         
         for(int cone=1; cone<=i; cone++)   
         {
            System.out.print("/\\");
         }
         
         for(int dot1=CONSTANT-1; dot1>=i; dot1--)
         {
            System.out.print(".");
         }
         
         System.out.print("|");
         System.out.print("\n");
      }   
   }
   
   public static void drawTopHalf()
   {
      for(int i=1; i<=CONSTANT; i++)
      {
         System.out.print(" ");
         System.out.print("|");
         
         for(int dot=1; dot<=i-1; dot++)
         {
            System.out.print(".");
         }
         
         for(int cone=CONSTANT; cone>=i; cone--)   
         {
            System.out.print("\\/");
         }
         
         for(int dot=1; dot<=i-1; dot++)
         {
            System.out.print(".");
         }
         
         for(int dot=1; dot<=i-1; dot++)
         {
            System.out.print(".");
         }
       
         for(int cone=CONSTANT; cone>=i; cone--)   
         {
            System.out.print("\\/");
         }
         
         for(int dot=1; dot<=i-1; dot++)
         {
            System.out.print(".");
         }
         
         System.out.print("|");
         System.out.print("\n");
      }
   }
   
   public static void drawBottom()
   {
      drawTopHalf();
      drawBottomHalf();
   }
   
   public static void drawTop()
   {
      drawBottomHalf();
      drawTopHalf();
   }
   
   public static void drawLine()
   {
      System.out.print(" +");
      for(int i=0; i<=CONSTANT*2-1; i++)
      {
         System.out.print("=*");
      }
      System.out.print("+");
      System.out.print("\n");
   }
}