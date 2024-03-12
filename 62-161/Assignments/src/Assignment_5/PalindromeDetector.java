package Assignment_5;

public class PalindromeDetector {

	public static void main(String[] args) {
		// Create an array of Strings
		String[] testString = {"Able was I ere I saw Elba",
		"Four score and seven year ago",
		"Desserts I stressed",
		"Ask not what your country can do for you",
		"Kayak"};

		// Repeat the process up to end of the String 
		for (String s : testString) {
			System.out.print("\"" + s + "\"");
			if (isPalindrome(StripSTR(s)))
				System.out.println(" is a palindrome.");
			else
				System.out.println(" is not a palindrome.");
		}
	}

	// The StripSTR method used to convert the alphabets to upper case.
	public static String StripSTR(String strip){
		strip = strip.toUpperCase();
		StringBuilder stripped = new StringBuilder();
		for (int i=0; i< strip.length(); i++){
			if (Character.isLetter(strip.charAt(i)))
				stripped.append(strip.charAt(i));
		}
		return stripped.toString();
	}

	// The isPalindrome method determines is a string is a palindrome or not.....
	public static boolean isPalindrome(String str){
		boolean status = false;
		if (str.length() <= 1) 
			status = true;
		else if (str.charAt(0) == str.charAt(str.length()-1)){      // calls a new string 
			status= isPalindrome(str.substring(1,str.length()-1));
		}
		return status;
	}
}