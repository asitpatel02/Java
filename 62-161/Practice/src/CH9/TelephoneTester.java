package CH9;
// Code Listing 9-7 pg#628

import java.util.Scanner;

public class TelephoneTester {

	public static void main(String[] args) {

		String phoneNumber;     // To hold a phone number

		// Create a Scanner object for keyboard input
		Scanner keyboard = new Scanner(System.in);

		// Get an unformatted telephone number.
		System.out.print("Enter an unformatted telephone number: ");
		phoneNumber = keyboard.nextLine();

		// Format the telephone number.
		System.out.println("Formatted: " + Telephone.format(phoneNumber));

		// Get a formatted telephone number.
		System.out.println("Enter a telephone number formatted as");
		System.out.print("(XXX)XXX-XXXX : ");
		phoneNumber = keyboard.nextLine();

		// Unformat the telephone number.
		System.out.println("Unformatted: " +
				Telephone.unformat(phoneNumber));
	}

}