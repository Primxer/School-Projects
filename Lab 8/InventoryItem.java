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
      if((id.matches("[0-9a-zA-Z]")))
      {
         throw new IllegalArgumentException("ID must contain at least one letter or one digit");
      }
      else
      {
         itemID = id;
      }
   }
   
   public void setDescription(String desc)
   {
      if((desc.matches("[a-zA-Z]")))
      {
         throw new IllegalArgumentException("Description must contain letters");
      }
      else
      {
         description = desc;
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