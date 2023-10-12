/*
    5. Write a short java program to compute factorial of a given integer from input using recursive function.

   Name: Asit Patel
   Student ID: 190309
 */

import java.util.Scanner;


public class Factorial {
    public static double recursion(int n){
        if (n==1){
            return n;
        }
        return n*recursion(n-1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the integer: ");
        int n = input.nextInt();
        double factorial = recursion(n);
        System.out.println("Factorial of " + n + " is: " + factorial);
    }
}
