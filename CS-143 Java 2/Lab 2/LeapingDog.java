import java.util.*;
public class LeapingDog extends YardDog
{
   public LeapingDog()
   {
      super();
   }
   
   public LeapingDog(int numRow, int numCols, String name)
   {
      super(numRow, numCols, name);
   }
   
   public int DigHoles()
   {
     Random rn = new Random();
     int holeCount = 0;
     boolean escape = false;
     do
     {
      int x = rn.nextInt((getNumRows()-2)-1)+ 2;
      int y = rn.nextInt((getNumColumns()-2)-1)+ 2;
      if(boneFound(x,y))
      {
       setElement(x,y, 'H');
       escape = true;
      }
      else
      {
       holeCount++;
       setElement(x,y, '.');  
      }
     }while(!escape);
     return holeCount;
   }
   
   public void leap()
   {
      Random rn = new Random();
      int x = rn.nextInt(getNumRows());
      int y = rn.nextInt(getNumColumns());
      boolean escape = false;
      while(escape == false)
      {
         if(x == 0 || x == getNumRows()-1 || y == 0 || y == getNumColumns()-1)
         {
            setElement(x,y, '@');
            System.out.println("true");
            escape = true;
         }
         else
         {
            x = x = rn.nextInt(getNumRows());
            y = rn.nextInt(getNumColumns());
         }
      }
   }
}