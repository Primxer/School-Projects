/*
   Ronnie C. Ripley
   Program to play rock paper or scissors using while, do-while, and random values
   425-623-4844(text available)
   Hours spent: 5.0
*/
import java.util.*; 
public class RPS{
   
   //Values and scanners to handle scores and inputs
   private static Scanner console = new Scanner(System.in);
   public static Random r = new Random();
   public static int computerMove = 0;
   public static int playerMove = 0;
   public static int playerScore = 0;
   public static int computerScore = 0;

   
   public static void main(String args[])
   {
      playGame();
   }
   
   //Processes the players input and stores it into an int for future managment 
   public static void playerMove()
   {
      System.out.println("Type R(ock), P(aper), or S(cissors): ");
      String move = console.next();
      while(!((move.equalsIgnoreCase("S")||move.equalsIgnoreCase("R")||move.equalsIgnoreCase("P"))))
      {
         System.out.println("Invalid answer. Re-type R, P or S: ");
         move = console.next();
      }
      if(move.equalsIgnoreCase("S"))
      {
         System.out.print("You played scissors.");
         playerMove = 0;
      }
      if(move.equalsIgnoreCase("R"))
      {
         System.out.print("You played rock.");
         playerMove = 1;
      }
      if(move.equalsIgnoreCase("P"))
      {
         System.out.print("You played paper.");
         playerMove = 2;
      }
   }
   
   //Processes the computers move by making a random int between 0 and 2 and stores it in an int for future managment
   public static void computerMove()
   {
      int move = r.nextInt(3);
      if(move == 0)
      {
         System.out.print(" The computer played scissors. \n");
         computerMove = 0;
      }
      else if(move == 1)
      {
         System.out.print(" The computer played rock \n");
         computerMove = 1;
      }
      else if(move == 2)
      {
         System.out.print(" The computer played paper \n");
         computerMove = 2;
      }
   }
   
   //This method practically calls the other methods of the class to play the RPS game by trapping the user in a loop until the user quits.
   public static void playGame()
   {
      String cont = "y";
      playerScore = 0;
      computerScore = 0; 
      boolean pass = false;
      do
      {
         if(cont.equalsIgnoreCase("y"))
         {
            playerMove();
            computerMove();
            checkRoundWin();
            System.out.println("Do you wish to play again?");
            cont = console.next();
          }
          else if(cont.equalsIgnoreCase("n"))
          {
            pass = true;
          }
          else
          {
            System.out.println("Incorrect input, please input Y or N");
            cont = console.next();
          }
      }while(!pass);
      
      checkGameWin();
   }
   
   //Checks who the winner of the game is by comparing the score of the player vs the computer.
   public static void checkGameWin()
   {
      System.out.printf("You won %d round(s). The computer won %d round(s). \n", playerScore, computerScore);
      if(playerScore == computerScore)
      {
         System.out.println("The game was a tie!");
      }
      else if(playerScore > computerScore)
      {
         System.out.println("You won the game!");
      }
      else if(playerScore < computerScore)
      {
         System.out.println("The Computer won the game");
      }
   }
   
   
   //Checks the winner of the round by checking Rock, Paper, and scissors choices made by the computer and player.
   public static void checkRoundWin()
   {
      if(playerMove == computerMove)
      {
         System.out.println("Its a tie!");
      }
      checkScissors();
      checkRock();
      checkPaper();
   }
   
   //Checks if the player played scissors, then compares to the computer choice and determines who wins.
   public static void checkScissors()
   {
      if(playerMove == 0)
      {
         if(computerMove == 1)
         {
            System.out.println("Computer Wins!");
            computerScore++;
         }
         else if(computerMove == 2)
         {
            System.out.println("You win!");
            playerScore++;
         }
      }
   }

   //Checks if the player played rock, then compares to the computer choice and determines who wins.
   public static void checkRock()
   {
      if(playerMove == 1)
      {
         if(computerMove == 2)
         {
            System.out.println("Computer Wins!");
            computerScore++;
         }
         else if(computerMove == 0)
         {
            System.out.println("You win!");
            playerScore++;
         }
      }
   }
   
   //Checks if the player played paper, then compares to the computer choice and determines who wins.
   public static void checkPaper()
   {
      if(playerMove == 2)
      {
         if(computerMove == 0)
         {
            System.out.println("Computer Wins!");
            computerScore++;
         }
         else if(computerMove == 1)
         {
            System.out.println("You win!");
            playerScore++;
         }
      }
   }
}