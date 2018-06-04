import java.util.*;
import java.io.*;
public class Test{
   public static void main(String args[]){
      ArrayList<String> playersList = new ArrayList<String>();
      playersList.add("Bob");
      playersList.add("Sally");
      playersList.add("George");
      AssassinManager ass = new AssassinManager(playersList);
      ass.printKillRing();
   }
}