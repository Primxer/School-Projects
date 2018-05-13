/*
   Ronnie C. Ripley
   Program to create a BT that contains QuestionNodes that can either be a 
   question or an anwser to the question.
   425-623-4844(txt available)
   Hrs: 5.0
*/

import java.util.*;
import java.io.*;

public class QuestionTree {

   public static Scanner console = new Scanner(System.in);
   private QuestionNode root = null;
   
   //QuestionNode class that stores the given input and nodes 'yes' and 'no' that 
   //store the answers or other questions to the root
   private static class QuestionNode
   {
      private String input = "";
      private QuestionNode yes;
      private QuestionNode no;
      
      public QuestionNode(String data)
      {
         if(data.equals(null))
            throw new IllegalArgumentException();
         else
         this.input = data;
      }
   }
   
   //Constructor method that fills the BT with multiple nodes of questions/answers
   public QuestionTree()
   {
      root = new QuestionNode("Computer");
   }
   
   void askQuestions()
   {
      askQuestions(root);
   }
   
   void askQuestions(QuestionNode data)
   {
     if(data.yes == null && data.no == null)
     {
         System.out.println("Is your object a " + data.input + "?");
         String yesno = console.nextLine();
         if(yesno.equalsIgnoreCase("y"))
         {
            System.out.println("Great, I got it right");
         }
         else
         {
            System.out.println("What is the name of your object?");
            String object = console.nextLine();
            System.out.println("Give me a yes/no question to distinguish object " + object + " from object " + data.input);
            String question = console.nextLine();
            System.out.println("What is the answer for object " + object + "? (y/n)");
            String yn = console.nextLine();
            QuestionNode adder = createNewSubTree(data, object, question, yn);
         }
     }
     else
     {
         System.out.println(data.input);
         String yesno = console.nextLine();
         if(yesno.equalsIgnoreCase("y"))
         {
            askQuestions(data.yes);
         }
         else
         {
            askQuestions(data.no);
         }
     }  
   }
   
   QuestionNode createNewSubTree(QuestionNode data, String object, String question, String yesno)
   {
      String previous = data.input;
      QuestionNode ret = new QuestionNode(question);
      if(yesno.equalsIgnoreCase("y"))
      {
         ret.yes = new QuestionNode(object);
         ret.no = new QuestionNode(previous);
      }
      else
      {
         ret.yes = new QuestionNode(previous);
         ret.no = new QuestionNode(object);
      }
      return ret;
   }
   
   void read(Scanner input)
   {
      
   }  
   
   //Default write method that calls the recursive form of itself
   public void write(PrintStream output)
   {
      write(root, output); 
   }
   
   //Recursive method that prints in preorder the BT to the given PrintStream
   private void write(QuestionNode data, PrintStream output)
   {     
      if(data != null)
      {
         if(data.yes == null && data.no == null)
            output.println("A: ");
         else
            output.println("Q: ");
            
            
         output.println(data.input);
         write(data.yes, output);
         write(data.no, output);
      }
      
   }
   /*
      METHOD: yesTo
      DESCRIPTION: Displays prompt to user and forces them
      to give valid Y/N response.
      @param prompt The prompt to be displayed before (y/n)? 
      @return true if user answered y in response to the prompt;
         false otherwise
      DO NOT MODIFY THIS CODE IN ANY WAY.
   */
   public boolean yesTo(String prompt) {
      System.out.print(prompt + " (y/n)? ");
      String response = console.nextLine().trim().toLowerCase();
      while (!response.equals("y")&& !response.equals("n")) {
         System.out.println("Please answer y or n.");
         System.out.print(prompt + " (y/n)? ");
         response = console.nextLine().trim().toLowerCase();
      }
      return response.equals("y");
   }//end yesTo() method  
   
}//end QuestionTree class