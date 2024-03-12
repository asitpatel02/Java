package CH8;
// Code Listing 8-15 pg#561

public class CourseDemo {

	public static void main(String[] args) {
		//Create an Instructor object
		Instructor myInstructor = new Instructor("kraner","Shawn","RH3010");

		//Create a TextBook object
		TextBook myTextBook = new TextBook("String out with java","Gaddis","Pearson");

		//Create a Course object
		Course myCourse = new Course("Intro to Java", myInstructor,myTextBook);

		//Display the course information
		System.out.println(myCourse);
	}
}
