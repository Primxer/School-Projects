import java.util.*;
public class Tester {
   public static Scanner console = new Scanner(System.in);
   public static void main(String args[])
   {
      int response = 0; 
      boolean pass = false;
      System.out.println("Please enter only a negative number: ");
      
      while(console.hasNextInt() && !pass)
      {
         console.next();
         response = console.nextInt();
         if(response < 0)
         {
            pass = true;
         }
         else
         {
            System.out.println("Invalid; please input only a negative number: ");
         }
      } 
     
   }
}