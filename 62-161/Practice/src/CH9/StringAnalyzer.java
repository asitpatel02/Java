package CH9;
//Code Listing 9-5 pg#614


import javax.swing.*;

public class StringAnalyzer {

	public static void main(String[] args) {

		String input;       // To hold input
		char[]  array;      // Array for input
		int letters = 0;    // Number of letters
		int digits = 0;     // Number of digits
		int whitespaces = 0;// Number of whites

		// get a string from the user.
		input = JOptionPane.showInputDialog("Enter a string");

		// Convert the string to a char array
		array = input.toCharArray();

		// Analyze the characters
		for (char c : array) {
			if (Character.isLetter(c)) letters++;
			else if (Character.isDigit(c)) digits++;
			else if (Character.isWhitespace(c)) whitespaces++;
		}

		// Display the results
		JOptionPane.showMessageDialog(null,"That string contains " + letters + " letters, " + digits + " digits, and " + whitespaces + " Whitespace characters.");

		System.exit(0);
	}
}