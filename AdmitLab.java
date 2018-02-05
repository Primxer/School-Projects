/*
   Ronnie C. Ripley
   425-623-4844(text available)
   A program similar to the ones used for admissions purposes using if\else statments, char, boolean values, printf methods, and throw exceptions.
   Hours spent: 2.0
*/
import java.util.*; 

class AdmitLab {
   
    private static Scanner console = new Scanner(System.in);
    
    public static void main(String[] args) {

        System.out.println("Welcome to the Admissions Aplicant Comparison System");
        System.out.println("Information for applicant #1:");
        double examScores1 = calculationsACTSAT(typeScore());
        double gpaScores1 = normalizedGPA();
        System.out.printf("\t Exam Score: %.1f \n", examScores1);
        System.out.printf("\t GPA score: %.1f \n", gpaScores1);
        System.out.println("Information for applicant #2:");
        double examScores2 = calculationsACTSAT(typeScore());
        double gpaScores2 = normalizedGPA();
        System.out.printf("\t Exam Score: %.1f \n", examScores2);
        System.out.printf("\t GPA score: %.1f \n", gpaScores2);
        betterApplicant(gpaScores1, gpaScores2, examScores1, examScores2);

            
    }
    
    // METHOD: typeScore()
    // PURPOSE: Determine if the type of scores are SAT or ACT scores.
    // EXCEPTION: Throw RuntimeException if user
    //              does not enter valid A, a, S or s value
    // RETURN: uppercase 'A' or 'S' based on user's input   
    public static char typeScore() 
    {

         System.out.println("\t Do you have (S)AT scores or (A)CT scores?");
         String response = console.next();
        
         if(response.equalsIgnoreCase("S"))
         {
            return Character.toUpperCase(response.charAt(0));  
         }
         else if(response.equalsIgnoreCase("A"))
         {
            return Character.toUpperCase(response.charAt(0));
         }
         else
         {
            throw new IllegalArgumentException("Invalid score type. Must be S, s, A, or a.");
         }
    }
    
    // METHOD: getExamScore()
    // PURPOSE: Get a SINGLE valid SAT or ACT score from the user, 
    //      as indicated by parameters.
    // PARAMETERS: SAT_Score and prompt
    //      When SAT_Score parameter is true, 
    //          user must enter score between 200 and 800.
    //      When SAT_Score parameter is false, 
    //          user must enter score between 1 and 36.
    //      prompt parameter will have the value "MATH", "READING", 
    //          "WRITING", "ENGLISH" or "SCIENCE".
    // EXCEPTION: Throw RuntimeException if user enters invalid scores.
    // RETURN: valid SAT or ACT test score  
    public static int getExamScore(boolean SAT_Score, String prompt) 
    {
      if(SAT_Score)
      {
         System.out.println("\t Enter " + prompt + " score between 200 and 800: ");
         int response = console.nextInt();
         if(response>=200 && response <=800)
         {
            return response;
         }
         else
         {
            throw new IllegalArgumentException("Value must be between 200 and 800.");
         }
      }
      else
      {
         System.out.println("\t Enter " + prompt + " score between 1 and 36: ");
         int response = console.nextInt();
         if(response>=1 && response <=36)
         {
            return response;
         }
         else
         {
            throw new IllegalArgumentException("Value must be between 200 and 800.");
         }
      }
    }

    //METHOD: normalizedSAT()
    //PURPOSE: compute normalized SAT score based on parameters
    //PARAMTERS: math, reading and writing contain an applicant's
    //  math, reading and writing SAT scores.
    //RETURN: the normalized SAT score between 0 and 100
    public static double normalizedSAT(int math, int reading, int writing) 
    {
      double answer =((2*math+reading+writing)/32.0);
      return answer;
    }
   
    //METHOD: normalizedACT()
    //PURPOSE: compute normalized ACT score based on parameters
    //PARAMTERS: math, reading, english and science contain an applicant's
    //  math, reading, english and science ACT scores.
    //RETURN: the normalized ACT score between 0 and 100
    public static double normalizedACT(int math, int reading, int english, int science) 
    {
      double answer = ((english+2*math+reading+science)/1.8);
      return answer;
    }
    
    /*
      Method: calculationsACTSAT()
      Purpose: recieve user exam input and calculate the normalized versions of the SAT and ACT
      Parameters: satOrAct is a char that determines if either the SAT prompts are displayed or the ACT
    */
    public static double calculationsACTSAT(char satOrAct)
    {
      
      if(satOrAct == 'S')
      {
         int mathScore = getExamScore(true, "MATH");
         int readingScore = getExamScore(true, "READING");
         int writingScore = getExamScore(true, "WRITING");
         
         double calculations = normalizedSAT(mathScore, readingScore, writingScore);
         return calculations;
      }
      else if(satOrAct == 'A')
      {
         int englishScore = getExamScore(false, "ENGLISH");
         int mathScore =  getExamScore(false, "MATH");
         int readingScore =  getExamScore(false, "READING");
         int scienceScore = getExamScore(false, "SCIENCE");
         
         double calculations = normalizedACT(mathScore,readingScore,englishScore,scienceScore);
         return calculations;
      }
      else
      {
         return 0;
      }
    }
    
    /*
      Method: normalizedGPA()
      Purpose: Ask for user input regarding max and overall gpa as well as transcript multiplier and then uses them to calculate the overall gpa score
    */
    public static double normalizedGPA()
    {
       System.out.println("\t Overall GPA?");
       double overallGPA = console.nextDouble();
       System.out.println("\t Max GPA?");
       double maxGPA = console.nextDouble();
       System.out.println("\t Transcript Multiplier? ");
       double transcriptMultiplier = console.nextDouble();
       double calculations = (overallGPA/maxGPA)*100*transcriptMultiplier;
       return calculations;
    }
    
    /*
      Method: betterApplicant()
      Purpose: To calculate the 2 applicants scores and determine which is better overall
      Parameters: gpaScores and examScores are doubles that will be added together based on the applicant 
    */
    public static void betterApplicant(double gpaScore1, double gpaScore2, double examScore1, double examScore2)
    {
      System.out.print("\n");
      double firstApplicant = gpaScore1 + examScore1;
      System.out.printf("First applicant overall score: %.1f \n", firstApplicant);
      double secondApplicant = gpaScore2 + examScore2;
      System.out.printf("Second applicant overall score: %.1f \n", secondApplicant);
      
      if(firstApplicant > secondApplicant)
      {
         System.out.println("The first applicant seems to be better");
      }
      else if (secondApplicant > firstApplicant)
      {
         System.out.println("The second applicant seems to be better");
      }
      else if(firstApplicant == secondApplicant)
      {
         System.out.println("The two applicants seem to be equal");
      }
    }
}
    
    
    
    
    
    
