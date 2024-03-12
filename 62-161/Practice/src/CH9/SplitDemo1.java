package CH9;
//Code Listing 9-8 pg#630

public class SplitDemo1 {

	public static void main(String[] args) {

		String str = "one two three four";  // create string to tokenize

		String[] tokens = str.split(" ");   // get the token, using a space delimiter

		for (String s : tokens)
			System.out.println(s);  // Display the tokens
	}
}
