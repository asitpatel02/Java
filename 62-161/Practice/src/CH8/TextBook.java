package CH8;
//Code Listing 8-13 pg#557

public class TextBook {

	private String title;   //Title of the book
	private String author;  //Author's last name
	private String publisher;   //Name of Publisher

	/**
	 * this constructor initializes the title author and publisher fields
	 * @param textTitle THe book's title
	 * @param auth the author's name.
	 * @param pub the name of the publisher.
	 */

	public TextBook(String textTitle, String auth,String pub){
		title = textTitle;
		author = auth;
		publisher = pub;
	}

	/**
	 * the copy constructor initializes the object as a copy of another textbook object
	 * @param object2 the object to copy
	 */

	public TextBook(TextBook object2){
		title = object2.title;
		author = object2.author;
		publisher = object2.publisher;
	}

	/**
	 * the set method sets a value for each field
	 * @param textTitle the book's title
	 * @param auth the author's name
	 * @param pub the name of the publisher.
	 */

	public void set(String textTitle, String auth, String pub){
		title = textTitle;
		author = auth;
		publisher = pub;
	}

	/**
	 * toString method
	 * @return A String Containing the textbook information
	 */

	public String toString(){
		//Create a String representing the object
		String str = "Title: " + title +
				"\nAuthor: " + author +
				"\nPublisher: " + publisher;

		//Return the string
		return str;
	}
}