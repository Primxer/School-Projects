
import java.util.*;
import java.io.*;
public class CashRegister
{
   public static Scanner console = new Scanner(System.in);
   public static double TAX = 7.8;
   public static void main (String args[]) throws FileNotFoundException
   {
      InventoryItem[] inventory = new InventoryItem[100];
      PrintStream newF = new PrintStream("receipts.txt");
      Scanner file = new Scanner(new File("Inventory.txt"));
      int count = 0;
      
      while(file.hasNextLine())
      {
         inventory[count] = new InventoryItem();
         inventory[count].setItemID(file.nextLine());
         inventory[count].setDescription(file.nextLine());
         while(file.hasNextDouble())
         {
            inventory[count].setPrice(file.nextDouble());
            
            if(file.hasNextDouble())
            {
               file.nextDouble();
            }
         }
         if(file.hasNextLine())
         {
            file.nextLine();
         }

         count++;
      }
      
      
      checkOut(inventory,count,newF); 
   }
   
   public static int indexOf(InventoryItem[] inv, String seekID, int size)
   {
      for(int i=0; i<size; i++)
      {
         if(inv[i].getItemID().equals(seekID))
         {
            return i;
         }
      }
      return -1;
   }
   
   public static void addReceipt(PrintStream output, InventoryItem[] inv, int quantity, String ID, int size)
   {
      output.printf("%11s%s"," ",inv[indexOf(inv,ID,size)].getDescription());
      output.printf("%3s%s @", " ",quantity);
      output.printf("%5s%s"," ",inv[indexOf(inv,ID,size)].getPrice());
      output.printf("%5s%s"," ",inv[indexOf(inv,ID,size)].getPrice());
      output.println("\n");
      
      
   }
   
   public static void printReceipt(PrintStream output, double total)
   {
      output.printf("%3s ======"," ");
   }
   
   public static void checkOut(InventoryItem[] inv,int size,PrintStream output)
   {
      double total = 0.0;
      String exit = "y";
      String input = " ";
      String previousID = " ";
      int quantity = 0;
      output.printf("%19s SVC CS 142 Store Receipt"," " );
      output.println();
      do
      {
         do
         {
            System.out.println("Enter Item ID(0 when done)> ");
            input = console.nextLine();
            if(!input.equalsIgnoreCase("0"))
            {
               previousID=input;
               if(indexOf(inv, previousID, size) == -1)
               {
                  System.out.println("Incorrect Item ID, Please try again");
               }
               else
               {
                  total += quantity*(inv[indexOf(inv,previousID,size)].getPrice());
                  System.out.println("Enter quantity> ");
                  quantity = console.nextInt();
                  console.nextLine();
                  addReceipt(output,inv,quantity, previousID,size); 
               }
            }
                        
         }while(!input.equalsIgnoreCase("0"));
         
         printReceipt(output, total);
         System.out.println("Thank you for shopping at the SVC CS 142 Store!");
         System.out.println("Don't forget to take your reciept.");
         System.out.println("Process another Customer?");
         exit = console.nextLine();
      }while(exit.equalsIgnoreCase("y"));
   }
}