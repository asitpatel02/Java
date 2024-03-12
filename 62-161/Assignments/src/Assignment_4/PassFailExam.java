package Assignment_4;



public class PassFailExam extends PassFailActivity {

	public PassFailExam(int questions, int missed, double minPassing)
	{

		super(minPassing);

		double numericScore;

		// Points for each question:
		double pointsEach = 100.0 / questions;
		numericScore = 100.0 - (missed * pointsEach);

		setScore(numericScore);
	}
}