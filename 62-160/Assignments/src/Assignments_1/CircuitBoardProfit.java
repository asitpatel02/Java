package Assignments_1;

import java.util.Scanner;


public class CircuitBoardProfit {

    private final static double PROFIT_AS_PERCENT = 0.4;

    private static double calculateProfit(double retailPrice)
    {
        return retailPrice * PROFIT_AS_PERCENT;
    }

    //Main
    public static void main(String[] args) {

        // Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        // Get the number of years.
        System.out.print("Enter the circuit board's retail price: ");
        double retailPrice = keyboard.nextDouble();

        // Call method to calculate profit.
        double profit = calculateProfit(retailPrice);

        // Display the amount of profit.
        System.out.print("Amount of Profit: $");
        System.out.printf("%.2f%n", profit);

        // close keyboard
        keyboard.close();
    }

}