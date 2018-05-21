/*
   Ronnie C. Ripley
   Program that processes BNF grammer by sorting it into maps and sets which will later produce random elements of grammar to be produced.
   425-623-4844(txt available)
   Hrs: 5.0
*/ 
import java.util.*;
import java.io.*;

public class GrammarProcessor{
   private Map<String, String[]> rules = new TreeMap<String, String[]>();

   //Fills the rules map with the given list of strings 
   GrammarProcessor(List<String> grammar){
      if(grammar == null || grammar.size() == 0)
         throw new IllegalArgumentException();
      
      System.out.println("GrammarProcessor Constructor display of grammar parameter: ");
      for(String s: grammar){
         System.out.println(s);
      }
      
      for(String s: grammar){
         String[] parts = s.split("::=");
         String key = parts[0];
         for(String z: parts){
            String[] pieces = z.split("[|]");
            String[] array = new String[pieces.length];
            for(int i=0; i<array.length; i++){
               array[i] = pieces[i];
            }
            rules.put(key, array);
         }
      }
      
      printRules();     
   }
   
   //Method that prints the key with all the elements attached to the key in the rules map
   private void printRules(){
      System.out.println("GrammarProcessor constructor display of contents of rules map: ");
      for(String s: rules.keySet()){
         System.out.println(s);
         System.out.print("    ");
         String[] array = rules.get(s);
         for(int i=0; i < array.length; i++){
            if(i == array.length-1)
               System.out.print(" " + array[i]);
            else
              System.out.print(" " +array[i] + ","); 
         }
         System.out.println();
      }
   }

}