/*
Asit Pinakinbhai Patel
190309
62-373 Design & Analysis of Computer Algorithms
Assignment 1
 */

import java.io.*;
import java.util.Scanner;

// Class to find the maximum subarray sum in an array
public class MaxSubarray {

    // Function to find the maximum sum of the subarray that crosses the midpoint
    private static int maxCrossingSum(int[] A, int low, int mid, int high) {

        // Initialize the leftSum as the minimum possible value
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;

        // Loop from mid to low, adding the elements to sum
        // If the sum is greater than leftSum, update leftSum
        for (int i = mid; i >= low; i--) {
            sum += A[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        // Initialize the rightSum as the minimum possible value
        int rightSum = Integer.MIN_VALUE;
        sum = 0;

        // Loop from mid+1 to high, adding the elements to sum
        // If the sum is greater than rightSum, update rightSum
        for (int i = mid+1; i <= high; i++) {
            sum += A[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        // Return the sum of leftSum and rightSum
        return leftSum + rightSum;
    }

    // Recursive function to find the maximum subarray sum in an array
    private static int maxSubarray(int[] A, int low, int high) {
        // If the low and high are equal, return the element at that index
        if (low == high) {
            return A[low];
        }

        // Calculate the midpoint of the array
        int mid = (low + high) / 2;

        // Return the maximum of three cases:
        // 1. Maximum subarray sum in the left subarray
        // 2. Maximum subarray sum in the right subarray
        // 3. Maximum subarray sum that crosses the midpoint
        return Math.max(Math.max(maxSubarray(A, low, mid), maxSubarray(A, mid+1, high)), maxCrossingSum(A, low, mid, high));
    }

    // Main function that takes in the input and output files as command line arguments
    public static void main(String[] args) throws IOException {
        // Read the input file name from the command line argument
        String inputFile = args[0];

        // Read the output file name from the command line argument
        String outputFile = args[1];

        // Create a Scanner object to read from the input file
        Scanner sc = new Scanner(new File(inputFile));

        // Create a PrintWriter object to write to the output file
        PrintWriter pw = new PrintWriter(new File(outputFile));

        // Read the number of test cases from the input file
        int T = sc.nextInt();

        // Loop through all the test cases
        for (int i = 0; i < T; i++) {
            // Read the size of the array
            int S = sc.nextInt();
            int[] A = new int[S];
            // Read the elements of the array
            for (int j = 0; j < S; j++) {
                A[j] = sc.nextInt();
            }
            // Call the maxSubarray method to find the maximum subarray
            int maxSum = maxSubarray(A, 0, A.length-1);
            // Write the result to the output file
            pw.println(maxSum);
        }
        // Close the scanner and the print writer
        sc.close();
        pw.close();
    }
}