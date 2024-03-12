package Assignment_5;

import java.io.IOException;

public class FileArrayDemo {

	public static void main(String[] args) throws IOException {

		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8 };
		int[] test = new int[8];

		// Write the array to the file MyLetters.txt.
		FileArray.writeArray("MyNumbers.txt", numbers);

		// Read the contents of the file into the test array.
		FileArray.readArray(test);

		// Display the characters.
		System.out.print("The numbers read from the file are: ");
		for (int index : test) System.out.print(index + " ");
		System.out.println();
	}
}
