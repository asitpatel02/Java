package Assignments_4;

import java.util.Scanner;

public class IsPrimeMethod {

    /**
     The isPrime method determines whether a number is prime.
     @param userNumber The number to check.
     @return true if the number is prime, false otherwise.
     integer eventDivisions is work to divide event numbers
     */
    public static boolean isPrime(int userNumber){

        // int variable
        int eventDivisions = 0;

        // if statement for if user enter number is less then 1; then print false
        if(userNumber < 1){
            return false;
        }

        // for loop for check is it prime number or not
        for ( int currentDivision = 1; currentDivision <= userNumber; currentDivision++){
            if (userNumber % currentDivision == 0){
                eventDivisions = eventDivisions +1;
                if((eventDivisions > 2) || (userNumber == 1)){
                    return false;
                }
            }
        }
        return true;
    }

    // main
    public static void main(String[] args) {

        // int variable
        int num;

        // scanner class
        Scanner input = new Scanner(System.in);

        // enter the user number
        System.out.print("Enter the number:- ");
        num = input.nextInt();

        // print the isPrime method, returns
        System.out.println(isPrime(num));

        // exit program
        System.exit(0);
    }
}