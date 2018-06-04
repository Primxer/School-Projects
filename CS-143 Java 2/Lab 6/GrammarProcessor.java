/*
   Ronnie C. Ripley
   Program that processes BNF grammer by sorting it into maps and sets which will later produce random elements of grammar to be produced.
   425-623-4844(txt available)
   Hrs: 18.0
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
         fin = fin +s;
         fin+=" ";
      }
      
      return fin;

   }
   
   //Recursivly goes through rules non-terminals then adds to the given list if it has reached a terminal and adds the randomly selected rule to it
   private void generate(String symbol, List<String> array){
      List<String> choices = new ArrayList<String>();
      for(String s: rules.get(symbol)){
         choices.add(s);
      } 
     Random rn = new Random();
     int random = rn.nextInt(choices.size());
     String selection = choices.get(random);
     List<String> test = new ArrayList<String>();
     Scanner scan = new Scanner(selection);
     while(scan.hasNext()){
      test.add(scan.next());
     }
     for(String s: test){
        if(rules.containsKey(s)){
              generate(s, array);
        }
        else{
           array.add(s);
        }
     }  
   }
   
   //Calls the generate method the given number of times and adds and returns them in an array
   String[] generate(String symbol, int times)
   {  
      List<String> array = new ArrayList<String>();
      List<String> trimmed = new ArrayList<String>();
      for(int i=0; i< times; i++){
         generate(symbol, array);
         String temp = "";
         for(String s: array){
            temp += s;
            temp += " ";
         }
         trimmed.add(temp);
         array = new ArrayList<String>();
         
      }
      String[] re = new String[trimmed.size()];
      for(int i=0; i<re.length; i++){
         re[i] = trimmed.get(i);
      }
      return re;
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