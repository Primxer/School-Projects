/*
   Ronnie C. Ripley  
   425-623-4844(txt available 
   Program to create "assassin" nodes that contain names and points to 
   the persons target
   Hrs: 19
*/
import java.util.*;
import java.io.*;
public class AssassinManager{

   private AssassinNode killring;
   private AssassinNode graveyard=null;
   
   //Class to create Assassin nodes with players names, their killers names and the next value
   private static class AssassinNode {
      
      private String player;
      private String killer;
      private AssassinNode next;
      
      AssassinNode(String name){
         this.player = name;
         this.killer = null;
         this.next = null;
      }
   }
   
   //Constructor for AssassinManager class that sets the killring to the first name of the given arraylist
   public AssassinManager(ArrayList<String> playerNamesList) {
      
      if(playerNamesList == null || playerNamesList.isEmpty())
      {
         throw new IllegalArgumentException("Given List does not exsits or is empty");
      }
      
      killring = new AssassinNode(playerNamesList.get(0));
      
      AssassinNode current = killring;
      
      for(int i = 1; i < playerNamesList.size(); i++)
      {
         current.next = new AssassinNode(playerNamesList.get(i));
         current = current.next; 
      }
   }
   
   //Prints the killring by going through it and printing each name. If it is the last position then it will print the first name to accompany it 
   public void printKillRing()
   {
      AssassinNode current = killring; 
      while(current != null)
      {
         if(current.next == null)
         {
            System.out.println("    " + current.player + " is stalking " + killring.player);
            current = current.next;
         }
         else
         {
            System.out.println("    " + current.player + " is stalking " + current.next.player);
            current = current.next;
         }
      }  
   }
   
   //Prints the graveyard by going through it and printing each name. If it is at the last position it will print the first name to accompany it
   public void printGraveyard()
   {
      AssassinNode currentGrave = graveyard;
      while(currentGrave != null)
      {
         if(currentGrave.next == null)
         {
            System.out.println("    " + currentGrave.player + " was killed by " + graveyard.killer);
            currentGrave = currentGrave.next;
         }
         else
         {
            System.out.println("    " + currentGrave.player + " was killed by " + currentGrave.killer);
            currentGrave = currentGrave.next;
         }
      }
   } 
   
   //Scans through the kill ring and if it finds the given name then returns true, else false
   public boolean killRingContains(String name)
   {
      AssassinNode check = killring;
      
      while(check != null)
      {
         if(check.player.equalsIgnoreCase(name))
            return true;
         check = check.next;
      }
      
      return false;
   } 
   
   //Scans through the graveyard and if find the given name then returns true, else false
   public boolean graveYardContains(String name)
   {
      AssassinNode check = graveyard;
      
      while(check != null)
      {
         if(check.player.equalsIgnoreCase(name))
            return true;
         check = check.next;
      }
      
      return false;
   }
   
   //Scans through kill ring and if there is only one player remaining(when .next == null) then the game is over
   public boolean gameOver()
   {
      AssassinNode current = killring;
      
      if(current.next == null)
      {
         return true;
      }
      
      return false;
   }  
   
   //Goes through kill ring to find the last standng player and returns their name
   public String winner()
   {
      AssassinNode current = killring;
      
      if(gameOver())
      {
         return current.player;
      }
      return "";
   }
   
   /*
   This method first throws a exception if the killring is null or does not contain the name
   then if the first position is the given name then it will find the last name in the ring and 
   set that name as the "victims" killer and remove that "victim" from the killring and put them into the graveyard
   if it is not the first position then it goes through the ring until it finds the given name. Once found
   it will repeat the same as above, setting the "victims" killer to the player before them and moving the 
   "victim" from the killring to the graveyard
   */
   public void kill(String name)
   {
      AssassinNode currentKill = killring;
      AssassinNode prevKill = null;
      AssassinNode victim = null;
      
      if(!(killRingContains(name)) || killring == null)
         throw new IllegalArgumentException();
      
      if(currentKill.player.equalsIgnoreCase(name))
      {
         victim = currentKill;
         
         while(currentKill != null)
         {
            if(currentKill.next == null)
            {
               victim.killer = currentKill.player;
            }
            currentKill = currentKill.next;
         }
         killring = killring.next;
         if(graveyard != null)
         {
            victim.next = graveyard;
         }
         else
         {
            victim.next = null;
         }
         
         graveyard = victim;
         return;
      }
      
      while(currentKill != null && !(gameOver()) && !currentKill.player.equalsIgnoreCase(name))
      {
         prevKill = currentKill;
         currentKill = currentKill.next;
      }
      
      if(currentKill == null)
         throw new IllegalArgumentException();
            
      prevKill.next = currentKill.next;
      victim = currentKill;
      if(graveyard != null)
      {
         victim.next = graveyard;
      }
      else
      {
         victim.next = null;
      }
      victim.killer = prevKill.player;
      
      graveyard = victim;
      
   }
}