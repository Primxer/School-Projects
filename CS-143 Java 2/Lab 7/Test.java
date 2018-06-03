public class Test{
   public static void main(String args[]){
     
      KillList test = new KillList();
      int index = 0;
      test.add(new AssassinNode("Bob"));
      index = test.indexOf("Bob");
      test.get(index).setKiller("George");
      test.add(new AssassinNode("Sally"));
      test.add(new AssassinNode("Mark"));
      test.add(new AssassinNode("George"));
      test.add(new AssassinNode("Jeff"));
      //System.out.println(test.toString());
      
      AssassinManager ass = new AssassinManager();
      ass.printKillRing();
   }
}