package CH8;
//Code listing 8-14 pg#559

public class Course {

	private String CourseName;  //Name of the course
	private Instructor instructor;  //The instructor
	private TextBook textBook;  //The textbook

	/**
	 * this constructor initializes the courserName instructor, and text fields
	 * @param Name the name of the course.
	 * @param instr an instructor object;
	 * @param Text a textbook object
	 */

	public Course(String Name,Instructor instr, TextBook Text){
		//Assign the courseName
		CourseName = Name;

		//Create a new instructor object, passing instr as an argument to the copy constructor
		instructor = new Instructor(instr);

		//Create a new TextBook object =, passing text as an argument to the copy constructor
		textBook = new TextBook(Text);
	}

	/**
	 * getName method
	 * @return the name of the course
	 */

	public String getName(){
		return CourseName;
	}

	/**
	 * getInstructor method
	 * @return A reference to a copy of this course's Instructor object
	 */

	public Instructor getInstructor(){
		//Return a copy of the instructor object
		return new Instructor(instructor);
	}

	/**
	 * toSting method
	 * @return A String containing the course information
	 */

	public String toString(){
		//Create a string representing the object
		String str = "Course name: " + CourseName +
				"\nInstructor Information:\n" + instructor +
				"\nTextbook Information:\n" + textBook;

		//Return the String
		return str;
	}
}
