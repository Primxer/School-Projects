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

      PrintStream newF = new PrintStream(new File("report2017.txt"));
      
      displayReportHeading(newF);
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
   
   public static void displayReportHeading(PrintStream output) throws FileNotFoundException
   {
      Scanner input = getInput(console);
      displayHeader(output);
      int count = 0;
      double totalTime = 0;
      double totalDistance = 0;
      String currentBest = " ";
      
      System.out.print("=\n ");
      output.print("=\n ");
      while(input.hasNextLine())
      {
         count++;
         String nextLine = input.nextLine();
         System.out.printf(" %s", nextLine);
         output.printf(" %s", nextLine);
                 
         while(input.hasNextDouble())
         {
            double next1 = input.nextDouble();
            //gitraceWinner((nextLine
            totalDistance += next1;
            double next2 = input.nextDouble();
            totalTime += next2;
            for(int i=1; i<=33-(nextLine.length()); i++)
            {
               System.out.print(" ");
               output.print(" ");
            }
            System.out.printf("%.2f ft     %.2f sec\n", next1, next2);
            output.printf("%.2f ft     %.2f sec\n", next1, next2);
         }
      }
      
      printEquals(60,output);
      summary(output,count/2+1,totalTime,totalDistance);
      
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
   
   //Displayes the summary at the end 
   public static void summary(PrintStream output, int count, double ttlTime, double ttlDistance)
   {
      System.out.print("\nTotal Number of Contestants: " + count);
      System.out.printf("\nAverage race time: %.2f", (ttlTime/count));
      System.out.printf("\nAverage toss distance: %.2f", (ttlDistance/count));
      
   }
   //Displays the header that consisit of the Contestants, distance, and time titles
   public static void displayHeader(PrintStream output)
   {
      printEquals(60,output);
      
      System.out.println("\n  Contestants                      Distance        Time");
      output.println("\n  Contestants                      Distance        Time");
      
      printEquals(59,output);
   }
   //Displays a row of equal symbols to the amount given
   public static void printEquals(int amount, PrintStream output)
   {
      for(int i=1; i<=amount; i++)
      {
         System.out.print("=");
         output.print("=");
      }
   }
}