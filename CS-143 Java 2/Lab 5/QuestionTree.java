/*
   Ronnie C. Ripley
   Program to create a BT that contains QuestionNodes that can either be a 
   question or an anwser to the question.
   425-623-4844(txt available)
   Hrs: 5.0
*/

import java.util.*;
import java.io.*;
import java.util.Scanner;

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
      System.out.println("Think of an object for me to guess...");
      askQuestions(root);
   }
   
   void askQuestions(QuestionNode data)
   {
     if(data.yes == null && data.no == null)
     {
         System.out.println("Is your object a " + data.input + "? (y/n)");
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
            QuestionNode newer = createNewSubTree(data, object, question, yn);
            root = add(root, newer, data.input);
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
   
   QuestionNode createNewSubTree(QuestionNode data, String object, String question, String yn)
   {
      String previous = data.input;
      QuestionNode newer = new QuestionNode(question);
      if(yn.equalsIgnoreCase("y"))
      {
         newer.yes = new QuestionNode(object);
         newer.no = new QuestionNode(previous);
      }  
      else if(yn.equalsIgnoreCase("n"))
      {
         newer.no = new QuestionNode(object);
         newer.yes = new QuestionNode(previous);
      }
      return newer;
      
   }
   
   QuestionNode add(QuestionNode data, QuestionNode newer, String previous)
   {
      if(data.input.equals(previous))
      {
         data = newer;
      }
      else if(data.yes != null)
      {
         data.yes = add(data.yes, newer, previous);
         if(data.no != null)
         {
            data.no = add(data.no, newer, previous);
         }
      }
      else if(data.no != null)
      {
         data.no = add(data.no, newer, previous);
      }
      return data;
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
   
   void read(Scanner input)
   {  
      read(root, input);
   }
   
   private void read(QuestionNode data, Scanner input)
   {
      if(input.hasNextLine())
      {
         input.nextLine();
         data = new QuestionNode(input.nextLine());
         if(input.nextLine().equalsIgnoreCase("a:"))
         {  
            input.nextLine();
            data.yes = new QuestionNode(input.nextLine());
            input.nextLine();
            data.no = new QuestionNode(input.nextLine());
         }
         read(data.yes, input);
         read(data.no, input);
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