/*
   Ronnie C. Ripley
   Main class that handles the QuestionTree program
   425-623-4844(txt available)
   Hrs: 5.0
*/ 

import java.util.*;
import java.io.*;

public class QuestionTreeClient {
   public static Scanner console = new Scanner(System.in);
      /*
         NOTE: The only input main() should perform is by calling the yesTo() 
         method of the QuestionTree class appropriately. DO NOT DECLARE A 
         Scanner OBJECT LINKED TO System.in WITHIN THIS CLASS.
         
         In the post-checkpoint version of your program, have main() call the 
         QuestionTree(), yesTo(), read(), write() and askQuestions()
         methods of the QuestionTree class appropriately to perform the following tasks:
         
         1. Create a QuestionTree object.
         
         2. If the user wants to override the tree with data from questions.txt,
            read the data from the file into the tree. 
            
         3. Keep playing the guessing game until the user wants to quit.
         
         4. Save the current tree in questions.txt if the user desires.
     
      */

   public static void main(String[] args)throws FileNotFoundException
   {
      QuestionTree test = new QuestionTree();
      String exit = "";
      String file = "data.txt";
      PrintStream output = new PrintStream(new File(file));
      System.out.println("Do you wish to read from previous tree?");
      String yn = console.nextLine();
      if(yn.equalsIgnoreCase("y"))
      {
         Scanner scan = new Scanner(new File(file));
         System.out.println(scan.nextLine());
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
         test.write(output);
         System.out.println("Tree has been saved");
      }
   }//end main() method
   
}//end QuestionTreeClient class