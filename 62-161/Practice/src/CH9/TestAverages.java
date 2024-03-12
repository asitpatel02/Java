package CH9;
// code listing 9-10 pg#640

import java.io.IOException;

public class TestAverages {

	public static void main(String[] args) throws IOException {
		double average;         // Test average
		int studentNumber = 1;  // Control variable

		// Create a TestScoreReader object.
		TestScoreReader scoreReader = new TestScoreReader("Grades.csv");

		// Display the averages.
		while (scoreReader.readNextLine())
		{
			// Get the average from the TestScoreReader.
			average = scoreReader.getAverage();

			// Display the student's average.
			System.out.println("Average for student " +
					studentNumber + " is " +
					average);

			// Increment the student number.
			studentNumber++;
		}

		// Close the TestScoreReader.
		scoreReader.close();
		System.out.println("No more scores.");
	}
}