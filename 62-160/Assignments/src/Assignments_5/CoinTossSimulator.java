package Assignments_5;

public class CoinTossSimulator {

    // Main method
    public static void main(String[] args) {

        // call method
        Coin penny = new Coin();

        // int variable
        int numberOfHeads = 0;
        int numberOfTails = 0;
        int numberOfTosses = 20;

        // initially randomly print
        System.out.println("Side initially facing up: " + penny.getSideUp() + "\n");

        // for loop
        for (int currentToss = 1; currentToss <= numberOfTosses; currentToss++){
            penny.toss();

            // counter
            if (penny.getSideUp() == "heads"){
                numberOfHeads += 1;
            } else {
                numberOfTails += 1;
            }
            System.out.println("Toss " + currentToss + ": " + penny.getSideUp());
        }
        // final statements
        System.out.println("\nOut of " + numberOfTosses + " tosses,\nthere were " + numberOfHeads + " heads and " + numberOfTails + " tails.");
    }
}