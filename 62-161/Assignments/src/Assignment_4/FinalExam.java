package Assignment_4;



public class FinalExam extends GradedActivity {

	public FinalExam(int questions, int missed)
	{
		double numericScore;

		// Points for each question:
		double eachPoints = 100.0 / questions;
		numericScore = 100.0 - (missed * eachPoints);

		setScore(numericScore);
	}
}