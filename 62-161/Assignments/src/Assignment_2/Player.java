package Assignment_2;

import java.util.Scanner;

public class Player {

	// Player number:
			private int points;                   // Player's points:
			private int currentAnswer;           // Current answer:

	public Player()
	{
		points = 0;
	}

	public void chooseAnswer()
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.print( "Choose the correct answer: " );
		currentAnswer = keyboard.nextInt();
	}

	public int getCurrentAnswer()
	{
		return currentAnswer;
	}

	public void countPoints()
	{
		points++;
	}

	public int getPoints()
	{
		return points;
	}
}
