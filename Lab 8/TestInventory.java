/*
   Ronnie C. Ripley
   Program to use InventoryItem class
   425-623-4844   
   Hrs:
*/ 

public class TestInventory
{
   public static void main(String args[])
   {
      InventoryItem def = new InventoryItem();
      InventoryItem hammer = new InventoryItem("00A","Hammer",45.99);
      
      System.out.println(def.getItemID());
      System.out.println(hammer.getItemID());
      
      def.setItemID("01A");
      def.setDescription("Default object");
      def.setPrice(100.55);
      hammer.setItemID("00B");
      hammer.setDescription("Its just a hammer");
      hammer.setPrice(50.00);
      
      System.out.println(def.getItemID());
      System.out.println(def.getDescription());
      System.out.println(def.getPrice());
      System.out.println(hammer.getItemID());
      System.out.println(hammer.getDescription());
      System.out.println(hammer.getPrice());
      
      //InventoryItem beam = new InventoryItem("0&A","beam",9.00);
      //InventoryItem beam = new InventoryItem("00A","B3am",9.00);
      //InventoryItem beam = new InventoryItem("00A","beam",-9.00);
      
      //hammer.setItemID("0*A");
      //hammer.setDescription("It's just a hammer");
      //hammer.setPrice(-42.99);
   }
}