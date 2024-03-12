package Assignment_4;

public class Essay extends GradedActivity
{
	private double grammar;                     // grammar points:
	private double spelling;                    // spelling points:
	private double correctLength;               // length points:
	private double content;                     // content points:



	public void setScore(double gr, double sp, double len, double cnt)
	{
		setGrammar(gr);
		setSpelling(sp);
		setCorrectLength(len);
		setContent(cnt);

		super.setScore(grammar + spelling + correctLength + content);           // Set total score:
	}

	private void setGrammar(double g)
	{
		if (g <= 30.0)
			grammar = g;
		else
			grammar = 0.0;
	}


	private void setSpelling(double s)
	{
		if (s <= 20.0)
			spelling = s;
		else
			spelling = 0.0;
	}


	private void setCorrectLength(double c)
	{
		if (c <= 20.0)
			correctLength = c;
		else
			correctLength = 0.0;
	}


	private void setContent(double c)
	{
		if (c <= 30)
			content = c;
		else
			content = 0.0;
	}

	public double getScore()
	{
		return grammar + spelling + correctLength + content;
	}
}