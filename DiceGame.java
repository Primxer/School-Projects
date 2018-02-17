/**
	PROGRAMMER: ???
	DESCRIPTION: Let human user roll dice against the computer.
		Hands are scored by counting the largest number of duplicate face values.
         The hand with the highest number of duplicate dice wins.
         If both hands have the same number of duplicates, the higher face value wins.
         There can be ties.
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
   public static Scanner kbd = new Scanner(System.in);

	public static void main(String[] args) {
       /* 
         This comment should be replaced with Java code that performs the following tasks:
       
            0.Declare and initialize variables needed for your program.
               You will need variables and/or arrays to hold the human's name,
               their preferred dice-hand size, the players' hands,
               and the scores associated with those hands.
            1. Greet the user, ask them for their name and the number of dice in a hand.
            2. Create hands (int arrays) of the appropriate size.
         
            Repeat
               3. Call rollDice() as needed to fill the hands with random dice values.
               4. Call showHand() as needed to display the hands.
               5. Call calulateScore() as needed to score the hands.
               6. Call scoreString() as needed to display the hand scores.
               7. Call compareTo() as needed to determine and display who won the round.
            Until the user wants to quit 
            
            8. Display good-bye!
      */

	}// end main() method
	
	/**
      METHOD: rollDice
      PURPOSE: Fill hand parameters with random 1-6 die values.
      PARAMETERS: hand1 and hand2 are two dice hands to be filled with
         random die values between 1 and 6.
	*/
	public static void rollDice(int[] hand1, int[] hand2) {
      /*
         Relace this comment with code that performs the following tasks:
            Declare a Random object as introduced in section 5.1.
            Use a for-loop to visit each location of hand1 and hand2.
            Assign a random value between 1 and 6 to each element in the hand arrays.
      */
      System.out.println("inside rollDice");//<--Delete this stub code when you have 
                                            //written the code to replace the comments.
	}// end rollDice() method
		
	/**
      METHOD: showHand
		PURPOSE: Display the player's hand of dice face values.
      The display will be formatted as follows:
         ______'s hand: # # # # etc.
      PARAMETER: player is the player's name or title
      PARAMETER: hand is the player's hand of dice values.
	*/
	public static void showHand(String player, int[] hand) {
      /*
         Replace this comment with code that performs the following tasks:
         Display ____'s hand:       <--where ____ is replaced by the player parameter
         Use a for-loop to display # # # etc.   <--where # # # is replace by die face value in hand
         Perform a println() to return the cursor to the beginning of the next line.
      */
      System.out.println("___'s hand: # # # # etc.");//<--Delete this stub code when you have 
                                                     //written the code to replace the comments.

	}// end showHand method()

	/**
	   METHOD: calculateScore
      PURPOSE: Calculate, create and return the score for the hand
      PARAMETER: hand is the hand to be scored
      RETURN: reference to newly created 2-element array holding score. 
         score[COUNT] holds count of the number of score[FACE]s
         i.e. 3 6s, 1 4, 5 1s, etc.  
	*/
	public static int[] calculateScore(int[] hand) {
      /*
         NOTE: Study the countDigits() method in the Benford.java program in section 7.7
         to see how to declare, create and return an array from a method.
         
         Replace this comment with code that performs the following tasks:
         
            Declare and create a 2-element int array to hold a score. You can name it anything
               you wish, but I will refer to it as score in these comments.
            Declare and create a 7-element int array to hold the count of each face value in the hand.
               You can name it anything you wish, but I will refer to it as counters in these comments.
         
            REMINDER: When you use the new operator to create an int array, each element
               in the newly created array is automatically initialized to 0.
         
            Use a for-loop to count the number of 1s, 2s, 3s,...,6s in the hand, 
               where counters[1] is used to count the 1s, counters[2] is used to count the 2s, etc.
               (counters[0] isn't used for anything.)
               
               HINT: See the Tally.java program in section 7.7 for an example of counting
               how many scores between 0 and 4 were earned on a quiz. Of course that
               program gets the data from a file. Your program is getting the data
               from the hand array. 
         
            Use a for-loop looking for the index of the largest counter in the array.
               For the purpose of this discussion, let's say the value is stored in
               a variable named maxIndex. 
               HINT: See the solution to the 7.2 WQuiz.
         
            If you do everything above correctly, 
               score[FACE] should be assigned maxIndex,
               score[COUNT] should be assigned counters[maxIndex]
               return score
      */
      return new int[2]; //<--Delete this stub code when you have written the code described 
                         //in the comment above.
                         //For now, this code returns a 2-element array containing zeros.
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
	public static String scoreString(int[] score) {
      /*
         Replace this comment with code that performs the following tasks:
            if the score parameter's COUNT value is 1
               return "1 " + the score's FACE value
            otherwise
               return "" + the score's COUNT value + " " + the score's FACE value followed by 's'
      */
      return "# #s"; //<--Delete this stub code when you have written the code described
                      //in the comment above.      
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
	public static int compareTo(int[] score1, int[] score2) {
      /*
         Replace this comment with code that performs the following tasks:
            Be sure you understand the rules for scoring described in the comments
            at the top of this file, and in the lab specs. 
            Then return 
               -1 if score1 < score2, 
                0 if score1 == score2, or 
                1 if score1 > score2.
      */
      return 0; //<--Delete this stub code when you have written the code for this function.
	}
	
}