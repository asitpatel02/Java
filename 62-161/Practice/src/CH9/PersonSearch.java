package CH9;
//Code Listing 9-4 pg#607

import java.util.Scanner;

public class PersonSearch {

	public static void main(String[] args) {

		String lookup;      // To hold lookup string

		// Create an array of names
		String[] people = {"Cutshaw, Will", "Davis, George",
				"Davis, Jenny", "Russert, Phil",
				"Russell, Cindy", "Setzer, Charles",
				"Smathers, Holly", "Smith, Chris",
				"Smith, Brad", "Williams, Jean" };

		// Create a Scanner object for keyboard input
		Scanner keyboard = new Scanner(System.in);

		// get a partial name to search for
		System.out.print("Enter the first few characters of the last name to look up: ");
		lookup = keyboard.nextLine();

		// Display all of the names that begin with the string entered by the user
		System.out.println("Here are teh names the match:");
		for (String person : people){
			if (person.startsWith(lookup))
				System.out.println(person);
		}
	}
}
