package Assignments_1;

import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {

        // Create a Scanner object for keyboard input
        Scanner keyboard = new Scanner(System.in);

        // Enter your city name
        System.out.print("Enter the name of your favorite city: ");

        // String
        String city = keyboard.nextLine();

        // close stream
        keyboard.close();

        // Display the number of characters
        System.out.println("THe number of characters in the city name: " + city.length());

        // Display the city name in uppercase characters
        System.out.println("The name of the city in all uppercase letter: "+city.toUpperCase());

        // Display the city name in lowercase characters
        System.out.println("The name of the city in all lowercase letters: "+city.toLowerCase());

        // Display the first character in the city name
        System.out.println("The first character in the name of the city: "+city.charAt(0));
    }
}