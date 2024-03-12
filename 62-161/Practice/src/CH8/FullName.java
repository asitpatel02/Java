package CH8;
//Code Listing 8-16 pg##565

public class FullName {

	private String LastName;    // Last Name
	private String FirstName;   // First Name
	private String MiddleName;  // Middle Name

	/**
	 * the setLastName method sets the lastName field
	 * @param str the String to set lastname to.
	 */

	public void setLastName(String str){
		LastName = str;
	}

	/**
	 * The setFirstName method sets the firstName field
	 * @param str The String to set firstName to.
	 */

	public void setFirstName(String str){
		FirstName = str;
	}

	/**
	 * The setMiddleName method sets the firstName field
	 * @param str The String to set firstName to.
	 */

	public void setMiddleName(String str){
		MiddleName = str;
	}

	/**
	 * The getLength method returns the length of the full name
	 * @return the length
	 */

	public int getLength(){
		return LastName.length() + FirstName.length() + MiddleName.length();
	}

	/**
	 * The toSting method returns the full name
	 * @return A reference to a String
	 */

	public String toString(){
		return FirstName + " " + MiddleName + " " + LastName;
	}
}
