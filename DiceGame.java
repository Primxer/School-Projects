/**
	PROGRAMMER: Ronnie C. Ripley
	DESCRIPTION: Let human user roll dice against the computer.
		Hands are scored by counting the largest number of duplicate face values.
         The hand with the highest number of duplicate dice wins.
         If both hands have the same number of duplicates, the higher face value wins.
         There can be ties.
    Phone #: 425-623-4844(text available)
    Hours spent: 2.5
*/

import java.util.*; 

public class DiceGame {
   
   /*
      A dice hand score will be the highest count of the highest face value in a dice hand.
      i.e. 4 1s, 3 6s, 2 2s, etc. In general a score is "count faces".
      A score array will hold that count and that face value.
   */
   public static final int COUNT = 0; //score[COUNT] holds count value of score.
   public static final int FACE = 1;  //score[FACE] holds face value corresponding to the count value.
   public static Scanner console = new Scanner(System.in);

	public static void main(String[] args) 
   {
      String playerName = "";
      String exit = "y";
      boolean pass = false;
      int diceHand = 0;
      int[] playerScore = new int[2];
      int[] computerScore = new int[2];
      
      playerName = displayWelcome();
      System.out.println("How many dice per hand?");
      diceHand = console.nextInt();
      int[] playerHand = new int[diceHand];
      int[] computerHand = new int[diceHand];
      do{
         if(exit.equalsIgnoreCase("y"))
         {
            rollDice(playerHand, computerHand);
            showHand(playerName, playerHand);
            showHand("Computer", computerHand);
            playerScore = calculateScore(playerHand);
            computerScore = calculateScore(computerHand);
            System.out.printf("%s's Score: %s\n", playerName, scoreString(playerScore));
            System.out.printf("Computers's Score: %s\n", scoreString(computerScore));
            displayWinner(playerScore, computerScore, playerName);
            System.out.println("Play another Round?");
            exit = console.next();
         }
         else if(exit.equalsIgnoreCase("n"))
         {
            pass = true;
         }
         else
         {
            System.out.println("Incorrect Input, please input Y or N");
            exit = console.next();
         }
      
      }while(!pass);
      System.out.println("Goodbye and thanks for playing!");
	}
	
	/**
      METHOD: rollDice
      PURPOSE: Fill hand parameters with random 1-6 die values.
      PARAMETERS: hand1 and hand2 are two dice hands to be filled with
         random die values between 1 and 6.
	*/
	public static void rollDice(int[] hand1, int[] hand2) 
   {
      Random r = new Random();
      for(int i=0; i<hand1.length; i++)
      {
         hand1[i] = r.nextInt(6)+1;
      }
      for(int n=0; n<hand2.length; n++)
      {
         hand2[n] = r.nextInt(6)+1;
      }
	}
		
	/**
      METHOD: showHand
		PURPOSE: Display the player's hand of dice face values.
      The display will be formatted as follows:
         ______'s hand: # # # # etc.
      PARAMETER: player is the player's name or title
      PARAMETER: hand is the player's hand of dice values.
	*/
	public static void showHand(String player, int[] hand) 
   {
      System.out.printf("%s's hand: ",player);  
      for(int i=0; i<hand.length; i++)
      {
         System.out.printf("%d ", hand[i]);
      }
      System.out.println(" ");
	}

	/**
	   METHOD: calculateScore
      PURPOSE: Calculate, create and return the score for the hand
      PARAMETER: hand is the hand to be scored
      RETURN: reference to newly created 2-element array holding score. 
         score[COUNT] holds count of the number of score[FACE]s
         i.e. 3 6s, 1 4, 5 1s, etc.  
	*/
	public static int[] calculateScore(int[] hand)
   {
      int[] score = new int[2];
      int[] counters = new int[7];
      
      for(int check: hand)
      {
         counters[check]++;
      }
      
      int maxI = 1;
      int max = counters[1];
      for(int i=0; i<counters.length; i++)
      {
         if(counters[i]>max)
         {
            max = counters[i];
            maxI = i;
         }
      }
      score[FACE] = maxI;
      score[COUNT] = counters[maxI];
      
      return score;
	}
   
   /**
      METHOD: scoreString 
      PURPOSE: Create string representation of a dice-hand score.
      PARAMETER: score is a 2-element array holding the count and face value of the score.
         Specifically, score[COUNT] holds the count value and score[FACE] holds the
         corresponding face value.
      RETURN: a string of the form "# #s" such as "2 1s" or "3 5s".
         If the score is just a single high die value, the string returned will
         be "1 1" or "1 2" or "1 3", etc. In other words, the "s" is not included
         in the string.
   */
	public static String scoreString(int[] score) 
   {
      if(score[COUNT] == 1)
      {
         String fill = "1 " + score[FACE];
         return fill;
      }
      else
      {
         String fill = "" + score[COUNT] + " " + score[FACE] + "'s";
         return fill;
      }   
	}
      
   /*
      METHOD: compareTo
      PURPOSE: This method will return a value of -1, 0 or 1 to indicate if
         the first score parameter is less than, equal to, or greater than
         the second score parameter.
      PARAMETER: score1 and score2 are the 2-element arrays holding the
         count and face values of two dice-hand scores.
      RETURN: -1 if score1 < score2  (score2 wins)
               0 if score1 == score2 (tie)
              +1 if score1 > score2  (score1 wins)
   */
	public static int compareTo(int[] score1, int[] score2) 
   {
      if(score1[COUNT] > score2[COUNT])
      {
         return 1;
      }
      else if(score1[COUNT] == score2[COUNT])
      {
         if(score1[FACE] > score2[FACE])
         {
            return 1;
         }
         else
         {
            return -1;
         }
      }
      else
      {
         return -1;
      }
	}
   
   
   //Takes in 2 score arrays then calls the compareTo method to find the winner then displays their scores comparativly and who won the round
   public static void displayWinner(int[] score1, int[] score2, String playerName)
   {
      int winner = compareTo(score1, score2);
      if(winner == 1)
      {
         String filler = score1[COUNT]+" "+score1[FACE] +"'s beats "+ score2[COUNT]+" "+score2[FACE]+"'s";
         System.out.println(filler);
         System.out.printf("%s wins the round!\n", playerName);
            
      }
      if(winner == -1)
      {
         String filler = score2[COUNT]+" "+score2[FACE]+"'s beats "+score1[COUNT]+" "+score1[FACE]+"'s"; 
                  System.out.println(filler);
         System.out.printf("The Computer wins the round!\n");
      }
      else if(winner == 0)
      {
         String filler = score1[COUNT]+" "+score1[FACE]+"'s is the same as "+score2[COUNT]+" "+score2[FACE]+"'s";
         System.out.println(filler);
         System.out.printf("It's a tie!\n");
      }
   }
   
   public static String displayWelcome()
   {
      System.out.println("Welcome to the lab 7 dice game!");
      System.out.println("What is your name?");
      return console.nextLine();
   }
}