package Assignment_2;

public class Question {

	public final int NUM_QUESTIONS = 10;

	// Trivia question
	private String questionText;

	// Array to hold answers
	private final String[] possibleAnswers = new String[ NUM_QUESTIONS ];

	private int correctAnswer;

	public Question()
	{
		questionText = "";
		correctAnswer = 0;
		for ( int index = 1; index <= NUM_QUESTIONS; index++ )
			setPossibleAnswer("", index);
	}

	public void setQuestion( String question )
	{
		questionText = question;
	}

	public void setPossibleAnswer( String text, int num )
	{
		possibleAnswers[ num - 1 ] = text;
	}

	public void setCorrectAnswerNumber( int num )
	{
		correctAnswer = num;
	}

	public String getQuestionText()
	{
		return questionText;
	}

	public String getPossibleAnswer( int num )
	{
		return possibleAnswers[ num - 1 ];
	}

	public int getCorrectAnswerNumber()
	{
		return correctAnswer;
	}

}