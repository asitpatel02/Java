package CH7;

import java.util.Scanner;

// Code Listing 7-9
public class PassArray {

    public static void main(String[] args) {
        final int ARRAY_SIZE = 4; // Size of the Array

        //Create an array
        int[] Numbers = new int[ARRAY_SIZE];

        // Pass the array to the getValues method
        getValues(Numbers);

        System.out.print(" Here are the Numbers that you entered: ");

        ShowArray(Numbers);
    }

    private static void getValues(int[] array){

        //Create a Scanner object for
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter a series of " + array.length + " numbers.");

        // Read values into the array
        for (int index = 0; index < array.length; index++){
            System.out.print("Enter number " + (index +1) + ": ");
            array[index] = keyboard.nextInt();
        }
    }

    public static void ShowArray(int[] array){

        // Display the array elements
        for (int index = 0; index< array.length; index++)
            System.out.print(array[index] + ", ");
    }
}
