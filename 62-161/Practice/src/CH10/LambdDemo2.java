package CH10;
// code listing 10-46 pg#727

import java.util.Scanner;

public class LambdDemo2 {

	public static void main(String[] args) {

		final int factor = 10;
		int num;

		// Create a Scanner object for keyboard input
		Scanner keyboard = new Scanner(System.in);

		// Create an object that implements IntCalculator
		IntCalculator multiplier = x-> x*factor;

		// get a number from the user
		System.out.print("Enter an integer number: ");
		num = keyboard.nextInt();

		// display the number multiplied by 10
		System.out.println("Multiplied by 10, that number is " + multiplier.calculate(num));
	}
}
