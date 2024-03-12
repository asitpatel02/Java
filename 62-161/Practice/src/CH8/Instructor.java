package CH8;
//Code Listing 8-12 pg#555

public class Instructor {

	private String LastName; // Last Name
	private String FirstName; // First Name
	private String officeNumber; // Office Number

	/**This Constructor initializes the last name, first name and office number
	 * @param Lname the Instructor's last name
	 * @param Fname the Instructor's last name
	 * @param office the office number
	 * */

	public Instructor(String Lname, String Fname, String office){
		LastName = Lname;
		FirstName = Fname;
		officeNumber = office;
	}

	/**
	 * THe copy constructor initializes the object as a copy of another Instructor object
	 * @param object2 the object to copy
	 */

	public Instructor(Instructor object2){
		LastName= object2.LastName;
		FirstName= object2.FirstName;
		officeNumber= object2.officeNumber;
	}

	/**
	 * the set method sets a value for each field
	 * @param Lname the Instructor's last name
	 * @param Fname the Instructor's last name
	 * @param office the Instructor's last name
	 */

	public void set(String Lname, String Fname, String office){
		LastName = Lname;
		FirstName = Fname;
		officeNumber = office;
	}
	/**
	toString method
	 @return a String Containing the instructor information.
	 */

	public String toString(){

		//Create a String representing the object
		String str = "Last Name: " + LastName +
					 "\nFirst Name: " + FirstName +
					 "\nOffice Number: " + officeNumber;

		// return the sting
		return str;
	}
}