package CH9;
// code listing 9-9 pg#638

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestScoreReader {

	private final Scanner inputFile;
	private String line;

	/**
	 The constructor opens a file to read
	 the grades from.
	 @param filename The file to open.
	 */

	public TestScoreReader(String filename)
			throws IOException
	{
		File file = new File(filename);
		inputFile = new Scanner(file);
	}

	/**
	 The readNextLine method reads the next line
	 from the file.
	 @return true if the line was read, false
	 otherwise.
	 */

	public boolean readNextLine() {
		boolean lineRead; // Flag variable

		lineRead = inputFile.hasNext();     // Determine whether there is more to read.

		if (lineRead)
			line = inputFile.nextLine();    // If so, read the next line.

		return lineRead;
	}

	/**
	 The getAverage method calculates the average
	 of the last set of test scores read from the file.
	 @return The average.
	 */

	public double getAverage()
	{
		int total = 0;    // Accumulator
		double average;   // The average test score

		String[] tokens = line.split(",");  // Tokenize the last line read from the file.

		for (String str : tokens)       // Calculate the total of the test scores.
		{
			total += Integer.parseInt(str);
		}

		average = (double) total / tokens.length;   // Calculate the average of the scores.  Use a cast to avoid integer division.

		return average;     // Return the average.
	}

	/**
	 The close method closes the file.
	 */

	public void close() {
		inputFile.close();
	}
}
