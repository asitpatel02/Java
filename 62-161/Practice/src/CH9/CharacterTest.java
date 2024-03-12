package CH9;
//Code Listing 9-1 pg#598

import javax.swing.*;

public class CharacterTest {

	public static void main(String[] args) {

		String input;   // To hold user's input
		char ch;        // TO hold a single character

		//Get a character from the user and store it in the ch variable
		input = JOptionPane.showInputDialog("Enter any single Character.");
		ch = input.charAt(0);

		// Test the Character
		if (Character.isLetter(ch)){
			JOptionPane.showMessageDialog(null, "That is a letter.");
		}

		if (Character.isDigit(ch)){
			JOptionPane.showMessageDialog(null,"That is a digit.");
		}

		if (Character.isLowerCase(ch)){
			JOptionPane.showMessageDialog(null,"That is an lowercase letter.");
		}

		if (Character.isWhitespace(ch)){
			JOptionPane.showMessageDialog(null,"That is a whitespace character.");
		}

		if (Character.isLowerCase(ch)){
			ch = Character.toUpperCase(ch);
			JOptionPane.showMessageDialog(null,"This is UpperCase: " + ch);
		}

		System.exit(0);
	}
}
