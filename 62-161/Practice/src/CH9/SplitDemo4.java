package CH9;

public class SplitDemo4 {

	public static void main(String[] args)
	{
		// Create a string to tokenize.
		String str = "Jill$Billy%Becky*Tara&Mary";

		// Get the tokens, using a space delimiter.
		String[] tokens = str.split("[$%*&]");

		// Display the tokens.
		for (String s : tokens)
			System.out.println(s);
	}
}
