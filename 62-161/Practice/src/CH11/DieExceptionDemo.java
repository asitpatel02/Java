package CH11;
// code listing 11-10 pg#767

public class DieExceptionDemo {
	public static void main(String[] args) {
		final int DIE_SIDES = 0;    // number of sides

		// create an instance of the die class
		Die die = new Die(DIE_SIDES);

		System.out.println("Initial value of the die: ");
		System.out.println(die.getValue());
	}
}
