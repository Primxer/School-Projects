public class AssassinNode{
   private String player;
   private String killer;
   
   AssassinNode(String name){
      player = name;
   }
   
   public boolean equals(Object other){
      if(other instanceof AssassinNode){
         if(player.equalsIgnoreCase(((AssassinNode)other).player)){
            return true;
         }
      }
      return false; 
   }
   
   public String getPlayer(){
      return player;
   }
   
   public String getKiller(){
      return killer;
   }

   public void setPlayer(String name){
      if(name.equals(null) || name.length() == 0){
         throw new IllegalArgumentException("Name has to be non-null or non-empty");
      }
      player = name;
   }
   
   public void setKiller(String name){
      if(name.equals(null) || name.length() == 0){
         throw new IllegalArgumentException("Name has to be non-null or non-empty");
      }
      killer = name;
   }
}