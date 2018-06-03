import java.util.*;
public class AssassinManager{
   private KillList killring = new KillList();
   private LinkedList<AssassinNode> graveyard = new LinkedList<AssassinNode>();
   
   public void printKillRing(){
      String list = killring.toString();
      String[] strings = list.split("#");
      for(String s: strings){
         //Scanner scan = new Scanner(s);
         //System.out.println(scan.next() + " is stalking " + scan.next());
         System.out.println(s);
      }  
   }
}