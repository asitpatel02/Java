package Assignments_1;

import java.util.Scanner;
import java.lang.Math;


public class  Convertor_respectively {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // initialize variables
        double cash; // initialize input variables
        double  cashleft; // initialize calculation variables
        int pennies, nickels, dimes, quarters, ones, fives, tens, twenties, fifties, hundreds;

        // CONSTANT VARIABLES
        double PENNIES = 0.01;
        double NICKELS = 0.05;
        double DIMES = 0.10;
        double QUARTERS = 0.25;
        double DOLLARS = 1;
        double FIVES = 5;
        double TENS = 10;
        double TWENTIES = 20;
        double FIFTIES = 50;
        double HUNDREDS = 100;

        {
            System.out.print("\n" + "Enter amount of cash: ");// Enter amount
            cash = input.nextDouble();// Read amount

            hundreds = (int) Math.floor(cash/HUNDREDS);// Dividend hundred
            fifties = (int) Math.floor((cash - hundreds * HUNDREDS)/FIFTIES);// Dividend hundred, fifty
            twenties = (int) Math.floor((cash - fifties * FIFTIES - hundreds * HUNDREDS)/TWENTIES);// Dividend hundred, fifty, twenties
            tens = (int) Math.floor((cash - fifties * FIFTIES - hundreds * HUNDREDS - twenties * TWENTIES)/TENS);// Dividend hundred, fifty, twenties, tens
            fives = (int) Math.floor((cash - fifties * FIFTIES - hundreds * HUNDREDS - twenties * TWENTIES - tens * TENS)/FIVES);// Dividend hundred, fifty, twenties, tens, fives
            ones = (int) Math.floor((cash - fifties * FIFTIES - hundreds * HUNDREDS - twenties * TWENTIES - tens * TENS - fives * FIVES));// Dividend hundred, fifty, twenties, tens, fives, ones

            cashleft = cash - fifties * FIFTIES - hundreds * HUNDREDS - twenties * TWENTIES - tens * TENS - fives * FIVES - ones * DOLLARS;// Cash left form hundred, fifty, twenties, tens, fives, ones

            cashleft = Math.round(cashleft * 100.0) /100.0;

            quarters =  (int) Math.floor(cashleft/.25);

            cashleft = cash - fifties * FIFTIES - hundreds * HUNDREDS - twenties * TWENTIES - tens * TENS - fives * FIVES - ones * DOLLARS - quarters * QUARTERS;// Dividend hundred, fifty, twenties, tens, fives, ones, quarters

            cashleft = Math.round(cashleft * 100.0) /100.0;

            dimes =  (int) Math.floor(cashleft/DIMES);

            cashleft = cash - fifties * FIFTIES - hundreds * HUNDREDS - twenties * TWENTIES - tens * TENS - fives * FIVES - ones * DOLLARS - quarters * QUARTERS - dimes * DIMES;// Dividend hundred, fifty, twenties, tens, fives, ones, quarters, dimes

            cashleft = Math.round(cashleft * 100.0) /100.0;

            nickels =  (int) Math.floor(cashleft/NICKELS);

            cashleft = cash - fifties * FIFTIES - hundreds * HUNDREDS - twenties * TWENTIES - tens * TENS - fives * FIVES - ones * DOLLARS - quarters * QUARTERS - dimes * DIMES - nickels * NICKELS;// Dividend hundred, fifty, twenties, tens, fives, ones, quarters, dimes, nickels

            cashleft = Math.round(cashleft * 100.0) /100.0;

            pennies =  (int) Math.floor(cashleft/PENNIES);// Dividend hundred, fifty, twenties, tens, fives, ones, quarters, dimes, nickels, pennies

            // Print correct change to give back
            if(hundreds > 0)
            {
                System.out.print("$100.00: "+ hundreds + "\n");
            }

            if(fifties > 0)
            {
                System.out.print("$50.00: " + fifties + "\n");
            }

            if (twenties > 0)
            {
                System.out.print("$20.00: " + twenties + "\n");
            }

            if (tens > 0)
            {
                System.out.print("$10.00: " + tens + "\n");
            }

            if (fives > 0)
            {
                System.out.print("$5.00: " + fives + "\n");
            }

            if (ones > 0)
            {
                System.out.print("$1.00: " + ones + "\n");
            }

            if (quarters > 0)
            {
                System.out.print("$0.25: " + quarters + "\n");
            }

            if (dimes > 0)
            {
                System.out.print("$0.10: " + dimes + "\n");
            }

            if (nickels > 0)
            {
                System.out.print("$0.05: " + nickels + "\n");
            }

            if (pennies > 0)
            {
                System.out.print("$0.01: " + pennies + "\n");
            }

        }

    }

}