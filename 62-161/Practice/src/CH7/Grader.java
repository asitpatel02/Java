package CH7;// Code Listing 7-12 it's connected to CH7.CalcAverage

public class Grader {

    //The testScores fields is a variable that will reference an array of test scores
    private double[] testScores;

    public Grader(double[] scoreArray){

        //Assign the array argument to the testScores field.
        testScores = scoreArray;
    }

    public double getLowestScore(){

        double lowest; //To hold the lowest score

        // Get the first test score in the array
        lowest = testScores[0];

        // Step through the rest of the array. when a value less then lowest is found, assign it to lowest.
        for (int index = 1; index < testScores.length; index++){
            if (testScores[index] < lowest)
                lowest = testScores[index];
        }

        // return the lowest test score
        return lowest;
    }

    public double getAverage(){

        double total = 0; // to hold score total
        double lowest; // to hold the lowest score
        double average; // to hold the average

        // if the array contains less then two test scores, display an error message and set average to 0.
        if (testScores.length < 2){
            System.out.println("ERROR: You must have at least two test scores!");
            average = 0;
        } else {

            // First, calculate the total of the scores.
            for (double score : testScores)
                total += score;

            // Nest, get the lowest score
            lowest = getLowestScore();

            // Subtract the lowest score from the total
            total -= lowest;

            // Get the adjusted average
            average = total / (testScores.length - 1);
        }

        // Return the adjusted average
        return average;
    }
}