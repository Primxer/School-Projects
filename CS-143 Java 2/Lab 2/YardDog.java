/*
   Ronnie C. Ripley
   Class that handles the YardDog object with constructors, accessors, and mutator methods
   425-623-4844(txt available)
   Hrs: 10.5
*/

import java.util.*;
public abstract class YardDog
{
   public static final int DEFAULT_ROWS = 15;
   public static final int DEFAULT_COLS = 20;
   public static final int MIN_ROWS = 5;
   public static final int MIN_COLS = 5;
   public static final int MAX_COLS = 75;
   
   private char yard[][];
   private static Scanner scan = new Scanner(System.in); 
   private String name;
   
   //Creates new YardDog object with given rows cols and name
   public YardDog(int numRows, int numCols, String name)
   {
      if(numRows < MIN_ROWS || numCols > MAX_COLS || numCols < MIN_COLS)
      {
         throw new IllegalArgumentException("Given values are outside the boundries");
      }
      yard = new char[numRows][numCols];
      buildYard();
      this.name = name;
   }
   
   //Creates default YardDog object
   public YardDog()
   {
      this(DEFAULT_ROWS, DEFAULT_COLS, "Dog");
   }
   
   //Builds the yard by creating a fence around the perimeter of the yard with empty space inside
   public void buildYard()
   {
      for(int row = 0; row < yard.length; row++)
      {  
         for(int col = 0; col < yard[0].length; col++)
         {
         
            yard[row][col] = ' ';
            
            if(col == 0 || col == yard[0].length-1)
            {
               yard[row][col] = '|';
               if(row == yard.length-1)
               {
                  yard[row][col] = '+';
               }
            }
            if(row == 0 || row == yard.length-1)
            {
               yard[row][col] = '-';
               if(col == 0 || col == yard[0].length-1)
               {
                  yard[row][col] = '+';
               }
            }
         }
      }
      
      Random rn = new Random();
      int x = rn.nextInt((yard.length-2)-1)+ 2;
      int y = rn.nextInt((yard.length-2)-1)+ 2;
      int prevx = 0;
      int prevy = 0;
      for(char bone = 'A'; bone <= 'C'; bone++)
      {
         x = rn.nextInt((yard.length-2)-1)+ 2;
         y = rn.nextInt((yard[0].length-2)-1)+ 2;
        
         while(x == prevx)
         {
            x = rn.nextInt((yard.length-2)-1)+ 2;
         }
         while(y == prevy)
         {
            y = rn.nextInt((yard[0].length-2)-1)+ 2;
         }
         yard[x][y] = bone;
      }
   }
   
   //Given values row and col are checked to see if they are or within a radius of the bone and returns true if so
   public boolean boneFound(int row, int col)
   {  
      for(char ch = 'A'; ch <= 'C'; ch++)
      {
         if(yard[row][col]==ch)
         {
            return true;
         }  

         if(row-1>=0)
         {
            if(yard[row-1][col]==ch)
            {
               return true;
            }
         }
         if(row+1<=yard.length-1)
         {
            if(yard[row+1][col]==ch)
            {
               return true;
            }
         }
         if(col-1>=0)
         {
            if(yard[row][col-1]==ch)
            {
               return true;
            }
         }
         if(col+1<=yard[row].length-1)
         {
            if(yard[row][col+1]==ch)
            {
               return true;
            }
         }
      }
      return false;
   }
   
   public abstract int DigHoles();
   
   //Traps user in loop until given x and y values find a bone using the findBone() method
   public int digHoles()
   {
      print();
      int x;
      int y;
      int holeCounter = 1;
      boolean release = false;
      do
      {
         System.out.print("Enter row and column numbers");
         x = scan.nextInt();
         y = scan.nextInt();
         
         if(boneFound(x,y))
         {
            yard[x][y] = 'H';
            release = true;
         }
         else
         {
            yard[x][y] = '.';
            holeCounter++;
         }
         print();
      
      }while(release == false);
      
      return holeCounter;
      
   }
   
   //Sets the given row and col element to the given char value ch
   public void setElement(int row, int col, char ch)
   {
      if(row > yard.length || col > yard[0].length || row < 0 || col < 0)
      {
         throw new IllegalArgumentException("Given values are outside the range of the yard");
      }
      yard[row][col] = ch;
   }
   
   //Prints the current contents of the yard array
   public void print()
   {
      for(int row = 0; row < yard.length; row++)
      {
         for(int column = 0; column < yard[0].length; column++)
         {
            System.out.print(yard[row][column]);
         }
         System.out.println("");
      }
      System.out.println(name);
   }
   
   //Returns the name 
   public String getName()
   {
      return name;
   }
   
   //Returns the number of rows in the yard array
   public int getNumRows()
   {
      return yard.length;
   }
   
   //Returns the number of columns in the yard array
   public int getNumColumns()
   {
      return yard[0].length;
   }
   
   //Returns the char value at the given row and column values in the yard array
   public char elementAt(int row, int column)
   {
      if(row > yard.length || column > yard[0].length || row < 0 || column < 0)
      {
         throw new IllegalArgumentException("Given values are outside the range of the yard");
      }
      return yard[row][column];
   }
   
   //Creates a returns a string of the current contents in the yard array
   public String toString()
   {
      String output = "";
      for(int row = 0; row < yard.length; row++)
      {
         for(int col = 0; col < yard[row].length; col++)
         {
            output += yard[row][col];
         }
         output += '\n';
      }
      return output;
   }
}