/*
   Ronnie C. Ripley
   Main class that handles the QuestionTree program
   425-623-4844(txt available)
   Hrs: 25.0
*/ 

import java.util.*;
import java.io.*;

public class QuestionTreeClient {
   public static Scanner console = new Scanner(System.in);

   //main method that contains a QuestionTree but prompts the user if they wish to load a save of the tree from a txt file
   //then calls the askQuestion method and after the user is done prompts if they wish to save to the same txt file as stated above
   public static void main(String[] args)throws FileNotFoundException
   {
      QuestionTree test = new QuestionTree();
      String exit = "";
      System.out.println("Do you wish to read from previous tree?");
      String yn = console.nextLine();
      if(yn.equalsIgnoreCase("y"))
      {
         Scanner scan = new Scanner(new File("Questions.txt"));
         test.read(scan);
      }
      do
      {
         test.askQuestions();
         System.out.println("Do you want to go again?");
         exit = console.nextLine();
      }while(exit.equalsIgnoreCase("y"));
      
      System.out.println("Do you wish to save?");
      String save = console.nextLine();
      if(save.equalsIgnoreCase("y"))
      {
         PrintStream output = new PrintStream(new File("questions.txt"));
         test.write(output);
         System.out.println("Tree has been saved");
      }
   }//end main() method
   
}//end QuestionTreeClient class