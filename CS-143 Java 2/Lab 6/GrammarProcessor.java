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
   }
   
   //Checks rules keySet and returns true if the given symbol is found
   boolean grammarContains(String symbol){
      for(String s: rules.keySet()){
         if(s.equals(symbol))
            return true;
      }
      return false;
   }
   
   //Returns a string of the keySet in rules
   String getSymbols(){
     return rules.keySet().toString();
   }
   
   //Calls the recursive form of itself to produce a random occurance of the given symbol 
   String generate(String symbol){
      List<String> array = new ArrayList<String>();
      if(!rules.containsKey(symbol))
         throw new IllegalArgumentException("Key not found"); 
      else{
         generate(symbol, array);
      }
      String fin = "";
      for(String s: array){
         fin += s;
      }
      
      return fin;

   }
   
   private void generate(String symbol, List<String> array){
      List<String> choices = new ArrayList<String>();
      for(String s: rules.get(symbol)){
         Scanner scan = new Scanner(s);
         while(scan.hasNext()){
            choices.add(scan.next());
         }
      } 
     Random rn = new Random();
     int random = rn.nextInt(choices.size());
     String selection = choices.get(random);
      if(rules.containsKey(selection)){
            generate(selection, array);
      }
      else{
         array.add(selection);
      }
       
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