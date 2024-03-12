package CH7;

import java.util.Scanner;

// Code Listing 7-6
public class DisplayTestScores {

    public static void main(String[] args) {

        int NumTests; // the number of tests
        int [] tests; // Array of test scores

        // create a scanner object for keyboard input
        Scanner keyboard = new Scanner(System.in);

        //get the number of test scores
        System.out.print("How many tests to you have? ");
        NumTests = keyboard.nextInt();

        // Create am array to hold the number of scores
        tests = new int[NumTests];

        // get the individual the test score
        for (int index = 0; index < tests.length; index++){
            System.out.print("Enter test score " + (index +1) + ": ");
            tests[index] = keyboard.nextInt();
        }

        // Display the tst Score
        System.out.println();
        System.out.println("Here are the scores your entered: ");
        for (int i = 0; i < tests.length; i++) {
            System.out.print(tests[i] + " ");
        }
    }
}
