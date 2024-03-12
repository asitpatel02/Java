package CH11;
// Code Listing 11-9 pg#765

import java.util.Random;

public class Die {

	private final  int MIN_SIDES = 4;
	private int sides;      // NUmber of sides
	private int value;      // The die's value

	public Die(int numSides){
		// validate the number of sides
		if (numSides < MIN_SIDES){
			throw new IllegalArgumentException(" the die must have at least " + MIN_SIDES + " sides.");
		}
		// store the number of sides and roll.
		sides = numSides;
		roll();
	}

	public void roll(){
		// create a random object
		Random rand = new Random();

		// get a random value for the die
		value = rand.nextInt(sides) + 1;
	}

	public int getSides(){
		return sides;
	}

	public int getValue(){
		return value;
	}
}
