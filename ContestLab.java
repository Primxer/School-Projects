/*
   Ronnie C. Ripley  
   425-623-4844(text available)
   Checkpoint program that asks user for a file name then reads out the contents of the file
   Hours spent: 2.0
*/
import java.util.*;
import java.io.*;
public class ContestLab {

   public static Scanner console = new Scanner(System.in);
   
   public static void main (String args[]) throws FileNotFoundException
   {
      //Scanner input = getInput(console);

   }
   
   //Gets a user input for the name of a file
   public static Scanner getInput(Scanner console) throws FileNotFoundException
   {
      System.out.println("Input file Name? ");
      File f = new File(console.nextLine());
      while(!f.canRead())
      {
         System.out.println("File Not Found. Try again.");
         System.out.println("Input file Name? ");
         f = new File(console.nextLine());
      }
      
      return new Scanner(f);
   }
   
   public static void displayReprotHeading(PrintStream output)
   {
      
   }
   
   //Takes in a string, then compares it to the taken newTime seeing which is lower and returns a modified string with the newTime and newName.
   public static String raceWinner(String currentBest, double newTime, String newName)
   {
      Scanner check = new Scanner(currentBest);
      double time = check.nextDouble();
      if(newTime < time)
      {
         currentBest = newTime + " " + newName;
         return currentBest;
      }
      else
      {
         return currentBest;
      }
   }
   
   public static String tossWinner(String currentBest, double newDistance, double newName)
   {
      Scanner check = new Scanner(currentBest);
      double distance = check.nextDouble();
      if(newDistance < distance)
      {
         currentBest = newDistance + " " + newName;
         return currentBest;
      }
      else
      {
         return currentBest;
      }
   }
   
   public static void summary(PrintStream output)
   {
   
   }
}