package CH9;
//Code Listing 9-3 pg#603

import java.util.Scanner;

public class CircleArea {

	public static void main(String[] args) {

		double radius;  // The circle;s radius
		double area;    // The Circle's area
		String input;   // To hole a line of input
		char Choice;    // To hold a single character

		// Create a Scanner object to read keyboard input
		Scanner keyboard = new Scanner(System.in);

		do {
			// Get the circle's radius
			System.out.print("Enter the circle's radius: ");
			radius = keyboard.nextDouble();

			// Consume the remaining newline character
			keyboard.nextLine();

			// Calculate and display the area.
			area = Math.PI * radius * radius;
			System.out.printf("The area is %.2f.\n",area);

			//Repeat this ?
			System.out.print("Do you want to do this again? (Y or N) ");
			input = keyboard.nextLine();
			Choice = input.charAt(0);
		} while (Character.toUpperCase(Choice) == 'Y');

	}
}
