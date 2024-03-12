package CH10;
// code listing 10-43 pg#722

import java.util.Scanner;

public class AnonymousClassDemo {

	public static void main(String[] args) {
		int num;

		// Create a Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in);

		// Create an object that implements IntCalculator
		IntCalculator square = new IntCalculator() {
			public int calculate(int number) {
				return number * number;
			}
		};
		// get a nu,ber from the user
		System.out.print("Enter an integer number: ");
		num = keyboard.nextInt();

		// display the square of the number
		System.out.println("The square is " + square.calculate(num));
	}
}
