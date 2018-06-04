import java.util.*;
import java.io.*;
public class AssassinManager{
   private KillList killring = new KillList();
   private LinkedList<AssassinNode> graveyard = new LinkedList<AssassinNode>();
   
   //Constructor method to add given list of player names to killring
   public AssassinManager(ArrayList<String> players){
      for(String s: players){
         killring.add(new AssassinNode(s));
      }
   }
   
   //Prints the current players in killring by spliting the .toString() method from killring
   public void printKillRing(){
      String[] array = killring.toString().split("\\n");
      for(String stalker: array){
         String[] players = stalker.split("#");
         System.out.println(players[0] + " is stalking " + players[1]);
      }  
   }
   
   //Prints the current players in the graveyard
   public void printGraveyard(){
      for(AssassinNode a: graveyard){
         System.out.println(a.getPlayer() + " was killed by " + a.getKiller());
      }
   }
   
   //if the game is over return the last player in killring
   public String winner(){
      if(gameOver()){
         return killring.get(0).getPlayer();
      }
      return "";
   }
   
   //Uses listiterator to scan threw graveyard to see if it contains given name. Returns true if found.
   public boolean graveyardContains(String name){
      ListIterator<AssassinNode> names = graveyard.listIterator();
      while(names.hasNext()){
         if(names.next().getPlayer().equalsIgnoreCase(name)){
            return true;
         }
      }
      return false;
   }
   
   //Modifys the killring and graveyard by removing the player with given name and moving them to the graveyard list
   public void kill(String name){
      if(gameOver()){//If gameOver then throw exception
         throw new IllegalArgumentException("Game is over");
      }
      ListIterator<AssassinNode> temp = killring.listIterator();
      while(temp.hasNext()){
         AssassinNode player = null;//Store temp.next for usage later
         if(player.getPlayer().equalsIgnoreCase(name)){
            if(!temp.hasPrevious()){//if temp does not have previous then set the killer as the last player in the list 
               player = temp.next();
               player.setKiller(killring.peekLast().getPlayer());
            }
            else{
               player = temp.next();
               player.setKiller(killring.get(temp.previousIndex()-1).getPlayer());
            }
            killring.remove(player);
            graveyard.add(player);
         } 
      }
   }
   
   //If the killring's size is equal to one then return true
   public boolean gameOver(){
      if(killring.size() == 1){
         return true;
      }
      return false;
   }
}