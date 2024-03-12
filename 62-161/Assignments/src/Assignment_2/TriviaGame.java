package Assignment_2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TriviaGame {
	public static void main(String[] args) throws IOException
	{

		final int NUM_QUESTIONS = 10;
		final int PLAYERS = 2;

		int playerTurn = 1;              // current player:


		Player [] players = new Player[ PLAYERS ];
		for ( int index = 0; index < PLAYERS; index++ )
		{
			players[ index ] = new Player();
		}

		// Array to hold question objects:
		Question [] questions = new Question[ NUM_QUESTIONS ];

		dataQuestion(questions);

		for ( int index = 0; index < NUM_QUESTIONS; index++ )
		{

			displayQuestion( questions[index], playerTurn );

			players[ playerTurn-1 ].chooseAnswer();          // Get the player's answer:

			if ( players[ playerTurn-1 ].getCurrentAnswer() == questions[index].getCorrectAnswerNumber() )
			{
				System.out.println( "That's correct!\n" );                      	          // The player's chosen answer is correct:
				players[ playerTurn-1 ].countPoints();
			}
			else
			{
				System.out.println( "Sorry, that is incorrect. The correct " +              // The player chose the wrong answer:
						"answer is " +
						questions[index].getCorrectAnswerNumber() +
						".\n" );
			}

			if ( playerTurn == 1 )
				playerTurn = 2;
			else
				playerTurn = 1;
		}

		showGameResults( players );
	}

	public static void dataQuestion(Question[] qArray) throws IOException
	{
		File file = new File( "trivia.txt" );
		Scanner inputFile = new Scanner(file);

		for ( int index = 0; index < qArray.length; index++ )
		{
			qArray[index] = new Question();                                  // Creates a question object:

			qArray[index].setQuestion( inputFile.nextLine());

			for (int j = 1; j <= 4; j++)
			{
				qArray[index].setPossibleAnswer( inputFile.nextLine(), j );
			}

			qArray[index].setCorrectAnswerNumber( Integer.parseInt( inputFile.nextLine() ) );
		}
	}
	public static void displayQuestion( Question q, int playerNum )
	{
		System.out.println( "Question for player #" + playerNum );         // Display the player number:
		System.out.println("------------------------");

		System.out.println( q.getQuestionText() );                       // Display the question:
		for ( int index = 1; index <= 4; index++ )
		{
			System.out.println(index + ". " + q.getPossibleAnswer(index));
		}
	}
	public static void showGameResults(Player[] players)
	{
		System.out.println("Game Over!");
		System.out.println("---------------------");
		System.out.println("Player 1's points: " + players[0].getPoints());
		System.out.println("Player 2's points: " + players[1].getPoints());

		if (players[0].getPoints() > players[1].getPoints())             // Declare the winner:
			System.out.println("Player #1 wins!");
		else if (players[1].getPoints() > players[0].getPoints())
			System.out.println("Player #2 wins!");
		else
			System.out.println("It's a TIE!");
	}
}
