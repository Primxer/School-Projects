import java.util.*;
public class KillList extends LinkedList<AssassinNode>{
   
   KillList(){
      super();
   }
   
   public int indexOf(Object other){
      if(other instanceof AssassinNode){
         return super.indexOf(other);
      }
      if(other instanceof String){
         AssassinNode temp = new AssassinNode((String)other);
         return super.indexOf(temp);
      }
      return super.indexOf(other);
   }
   
   public String toString(){
      if(this.size() == 0){
         return "";
      }
      String temp = "";
      ListIterator<AssassinNode> names = this.listIterator();
      temp += names.next().getPlayer();
      while(names.hasNext()){
         String name = names.next().getPlayer();
         temp += "#";
         temp += name;
         temp += "\n";
         temp += name;
      }
      temp += "#";
      temp += this.getFirst().getPlayer();
      temp += "\n";
      return temp;
   }
}