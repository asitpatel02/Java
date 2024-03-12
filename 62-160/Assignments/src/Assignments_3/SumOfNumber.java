package Assignments_3;

import java.util.Scanner;

public class SumOfNumber {

    //Main
    public static void main(String[] args) {

        // Scanner Input
        Scanner keyboard = new Scanner(System.in);

        // Variable
        int Number, i = 0, Sum = 0;

        // Input Integer
        System.out.print("Please Enter in a Nonzero integer: ");
        Number = keyboard.nextInt();

        // While loop
        while (i <= Number) {
            Sum = Sum + i;
            i++;
        }

        // Output
        System.out.println("The sum of terms from 1 to " + Number + " is: " + Sum);

        //Exit
        System.exit(0);
    }
}