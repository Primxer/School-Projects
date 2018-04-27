/*
   Ronnie C. Ripley
   425-623-4844
   Program to create an arraylist and fill with ContestantRecord's that will then be sorted 
   in various ways by overiding the existing methods of an arraylist
   Hrs: 10.0
*/

import java.util.*;
import java.io.*;
public class ContestLab{
   public static Scanner console = new Scanner(System.in);
   
   public static void main(String args[])throws IOException
   {
      ArrayList<ContestantRecord> contest = new ArrayList<ContestantRecord>();
      Scanner file = new Scanner(new File("contest2016.dat"));
      
      while(file.hasNextLine())
      {
         String name = file.nextLine();
         double distance = 0;
         double time = 0;
         
         while(file.hasNextDouble())
         {
            distance = file.nextDouble();
            time = file.nextDouble();
         } 
          
         file.nextLine(); 
         
         ContestantRecord contestant = new ContestantRecord(name, distance, time);
         contest.add(contestant);
      } 
      displayReport("Original Data", contest); 
      Collections.shuffle(contest);
      displayReport("Shuffled Data", contest);
      Collections.sort(contest);
      displayReport("Contest Results Sorted by Name", contest);
      Collections.sort(contest, new RaceComparator());
      displayReport("Race Results", contest);
      Collections.sort(contest, new TossComparator());
      displayReport("Results by Toss Distance", contest);
      
      String exit = " ";
      do{
         System.out.println("Enter target name to search for (or QUIT)");
         exit = console.nextLine();
         int i = -1;
         for(ContestantRecord s: contest)
         {
            if(s.getName().equalsIgnoreCase(exit))
               i = contest.indexOf(s);
         }
         
         if(i >= 0)
            System.out.printf("indexOf() shows %s had a toss of %.2f ft and a time of %.2f sec. \n", contest.get(i).contestant, contest.get(i).distance, contest.get(i).time);
         else
            System.out.printf("indexof() says %s is NOT in the list.\n", exit);
            
         Collections.sort(contest);
         int k = -1;
         for(ContestantRecord s: contest)
         {
            if(s.getName().equalsIgnoreCase(exit))
               k = contest.indexOf(s);
         }
         if(i >= 0)
            System.out.printf("binarySearch() says %s has a toss of %.2f ft and a time of %.2f sec.\n", contest.get(k).contestant, contest.get(k).distance, contest.get(k).time);
         else
            System.out.printf("binarySearch() says %s is NOT in the list.\n", exit);     
       }while(!(exit.equalsIgnoreCase("QUIT")));
   }
   
   //Displays the report of the given arraylist and title
   public static void displayReport(String title, ArrayList<ContestantRecord> list )
   {
      String equals = "==================================================";
      printSpaces(31-title.length());
      System.out.println(title);
      System.out.println(equals);
      System.out.println("   Contestants                    Ft      Secs");
      System.out.println(equals);
      for(ContestantRecord i: list)
      {
         System.out.printf("    %s", i.getName());
         printSpaces(27-i.getName().length());
         System.out.printf("%.2f     %.2f", i.getDistance(), i.getTime());
         System.out.println();
      }
      System.out.println();
   }
   
   //Used to print the give value of spaces
   public static void printSpaces(int amount)
   {
      for(int i = 0; i <= amount; i++)
      {
         System.out.print(" ");
      }
   }
   
   //Class that creates a record of a contestant and overides many different methods 
   public static class ContestantRecord implements Comparable<ContestantRecord> {
      public String contestant;
      public double distance;
      public double time;
      
      public ContestantRecord(String name, double distance, double time)
      {
         this.distance = distance;
         this.time = time;
         contestant = name;
      }
      
      //Overides the compare method in terms of the time 
      public int compare(ContestantRecord c1, ContestantRecord c2)
      {
         return (int) ((c1.getTime() - c2.getTime())*100);
      }
      
      //Overides the equals method for seeing if the contestant of an object is the same as contestant
      public boolean equals(Object o)
      {
         if(!(o instanceof ContestantRecord)){
            return false;
         }
         
         ContestantRecord test = (ContestantRecord) o;
         return test.contestant.equalsIgnoreCase(this.contestant);
      }
      
      //Overides the compareTo method for comparing the two contestnat Strings
      public int compareTo(ContestantRecord test)
      {
         return contestant.toLowerCase().compareTo(test.getName().toLowerCase());
      }
      
      //Returns contestnat
      public String getName()
      {
         return contestant;
      }
      
      //Returns distance
      public double getDistance()
      {
         return distance;
      }
      
      //Returns time
      public double getTime()
      {
         return time;
      }
      
      //Returns the contestant distance and time in a string
      public String toString()
      {
         return contestant + " " + distance + " " + time + " ";
      }
   }
   
   //Class that overides the compare method for compare ContestantRecords in terms of their times
   public static class RaceComparator implements Comparator<ContestantRecord>
   {
      public int compare(ContestantRecord c1, ContestantRecord c2)
      {
         return ((int)(c1.getTime()*100)) - ((int)(c2.getTime()*100));
      }
   }
   
   //Class that overides the compare method for comparing ContestantRecords in terms of their distance
   public static class TossComparator implements Comparator<ContestantRecord>
   {
      public int compare(ContestantRecord c1, ContestantRecord c2)
      {
         return ((int) (c2.getDistance()*100) - ((int)(c1.getDistance()*100)));
      }
   }
   
}