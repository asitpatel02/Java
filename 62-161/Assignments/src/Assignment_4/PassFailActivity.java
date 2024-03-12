package Assignment_4;


public class PassFailActivity extends GradedActivity
{
	private final double minPassingScore;                  // Minimum passing score:


	public PassFailActivity(double minPassScore)
	{
		minPassingScore = minPassScore;
	}



	public char getGrade()
	{
		char letterGrade;

		if (super.getScore() >= minPassingScore)
			letterGrade = 'P';
		else
			letterGrade = 'F';

		return letterGrade;
	}
}