package CH9;
//Code Listing 9-2 pg#600

import javax.swing.*;

public class CustomerNumber {

	public static void main(String[] args) {

		String input;       // To hold the user's input

		// Get a Customer number
		input = JOptionPane.showInputDialog("Enter a customer number in the from LLLNNNN\n" + "(LLL = Letters and NNNN = numbers");

		// Validate the input
		if (isValid(input)){
			JOptionPane.showMessageDialog(null,"That's a valid customer number.");
		} else {
			JOptionPane.showMessageDialog(null,"That is not the proper format of a customer number. \nHere is an Example: ABC1234");
		}
		System.exit(0);
	}

	private static boolean isValid(String custNumber) {
		boolean goodSoFar = true;       // Flag
		int i = 0;                      // Control Variable

		// Test the length
		if (custNumber.length() !=7){
			goodSoFar = false;
		}

		// Test the first three characters for letters
		while (goodSoFar && i < 3){
			if (!Character.isLetter(custNumber.charAt(i)))
				goodSoFar = false;
			i++;
		}

		// Test the last four characters for digits
		while (goodSoFar && i < 7){
			if (!Character.isDigit(custNumber.charAt(i)))
				goodSoFar = false;
			i++;
		}

		return goodSoFar;   // return
	}
}
