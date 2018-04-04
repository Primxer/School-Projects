
import java.util.*;
import java.io.*;
public class CashRegister
{
   //Public scanner and tax constant
   public static Scanner console = new Scanner(System.in);
   public static double TAX = 0.078;
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
   
   //Finds and returns the index of if a matching string is found in the array is found in the array
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
   
   //Prints to a file the price, description, and quantity of the items "purchased"
   public static void addReceipt(PrintStream output, InventoryItem[] inv, int quantity, String ID, int size)
   {
      output.printf("%12s%s"," ",inv[indexOf(inv,ID,size)].getDescription());
      output.printf("%3s%s @", " ",quantity);
      output.printf("%5s%s"," ",inv[indexOf(inv,ID,size)].getPrice());
      output.printf("%5s%s"," ",inv[indexOf(inv,ID,size)].getPrice());
      output.println("\n");
      
      
   }
   //Prints to a file the subtotal, tax, and the total of the items "purchased"
   public static void printReceipt(PrintStream output, double total)
   {
      
      printCharacter(" ",42,output);
      printCharacter("=",8,output);
      output.println();
      printCharacter(" ",30,output);
      output.printf("Subtotal        %.2f", total);
      output.println();
      printCharacter(" ",35,output);
      output.printf("Tax        %.2f \n", TAX*total); 
      output.println();
      if(total>10.00)
      {
         printCharacter(" ",32,output);
      }
      else
      {
         printCharacter(" ", 33,output);
      }
      output.printf("Total        %.2f \n", total+(TAX*total));
      output.println();
      printCharacter("-",56,output);
      output.println();
   }
   
   //Used to print a given character a given amount of times
   public static void printCharacter(String character, int amount, PrintStream output)
   {
      for(int i=1; i<=amount; i++)
      {
         output.print(character);
      }
   }
   
   //Handles the "checking out" of the user by asking them the items and amount while trapped in a sentinal loop
   public static void checkOut(InventoryItem[] inv,int size,PrintStream output)
   {
      double total = 0.0;
      String exit = "y";
      String input = " ";
      String previousID = " ";
      int quantity = 0;
      output.printf("%19s SVC CS 142 Store Receipt"," " );
      output.println();
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
                  System.out.println("Enter quantity> ");
                  quantity = console.nextInt();
                  console.nextLine();
                  total += quantity*(inv[indexOf(inv,previousID,size)].getPrice());
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