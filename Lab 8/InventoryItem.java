/*
   Class to manage the invetory items with a description, price, and ID
   Ronnie C. Ripley 
   425-623-4844(txt available)
   Hrs: 
*/

public class InventoryItem {
   private String itemID = "0A";
   private String description = "fill";
   private double price = 0.0;
   
   public InventoryItem()
   {
      itemID = "TBD";
      description = "TBD";
      price = 0.0;
   }
   public InventoryItem(String itemID, String desc, double price)
   {
      setDescription(desc);
      setItemID(itemID);
      setPrice(price);
   }  
   
   public void setItemID(String id)
   {
      if(id.matches("[0-9a-zA-Z]+"))
      {
         itemID = id;
      }
      else
      {
         throw new IllegalArgumentException("ID must contain at least one letter or one digit and only letters or digits");
      }
   }
   
   public void setDescription(String desc)
   {
      if(desc.matches("[0-9\\-a-z A-Z]+"))
      {
         description = desc;
      }
      else
      {
         throw new IllegalArgumentException("Description must contain letters");
      }
   }
   
   public void setPrice(double price)
   {
      if(price < 0)
      {
         throw new IllegalArgumentException("Price must be non-negative");
      }
      else
      {
         this.price = price;
      }
   }
   
   public String getItemID()
   {
      return itemID;
   }
   
   public String getDescription()
   {
      return description;
   }
   
   public double getPrice()
   {
      return price;
   }
}