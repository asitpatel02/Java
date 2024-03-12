package CH7;// Code Listing 7-13 it's connect to CH7.Grader

import java.util.Scanner;

public class CalcAverage {

    public static void main(String[] args) {

        int numScores; // To hold the number of scores

        // Create a Scanner object for keyboard input =
        Scanner keyboard = new Scanner(System.in);

        // Get the number of test scores
        System.out.print("How Many test scores do you have? ");
        numScores = keyboard.nextInt();

        // Create an array to hold the test Scores
        double[] scores = new double[numScores];

        // get the test score and store them in the scores array
        for (int index = 0; index < numScores; index++){
            System.out.print("Enter Score #" + (index + 1) + ": ");
            scores[index] = keyboard.nextDouble();
        }

        // Create a CH7.Grader object, passing the scores array as an argument to the constructor
        Grader myGrader = new Grader(scores);

        // Display the adjusted average
        System.out.println("Your adjusted average is " + myGrader.getAverage());

        // Display the lowest score
        System.out.println("Your lowest test score was " + myGrader.getLowestScore());
    }
}