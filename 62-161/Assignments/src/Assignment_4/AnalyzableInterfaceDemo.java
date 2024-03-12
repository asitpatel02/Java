package Assignment_4;

public class AnalyzableInterfaceDemo {

	public static void main(String[] args) {

		// Create an object for the Lab grade.
		GradedActivity Lab = new GradedActivity();
		// Set the Lab score at 85.
		Lab.setScore(85);

		// Create an object for the pass/fail exam.
		// 20 total questions, 3 questions missed, minimum
		// passing score is 70.
		PassFailExam PFE = new PassFailExam(20, 3, 70);

		// Create an object for the Essay grade.
		Essay Essay = new Essay();
		// Set the Essay scores. Grammar = 25, spelling = 18
		// length = 17, content = 20.
		Essay.setScore(25, 18, 17, 20);

		// Create an object for the final exam.
		// 50 questions, 10 missed.
		FinalExam FinalExam = new FinalExam(50, 10);

		// Create a CourseGrades object.
		CourseGrades course = new CourseGrades();
		course.setLab(Lab);
		course.setPassFailExam(PFE);
		course.setEssay(Essay);
		course.setFinalExam(FinalExam);

		// Display the scores and grades.
		System.out.println(course);

		// Display the average numeric score.
		System.out.println("Average score: " +
				course.getAverage());

		// Get the item with the highest score.
		GradedActivity highItem = course.getHighest();
		System.out.println("Highest score: " +
				highItem.getScore());

		// Get the item with the lowest score.
		GradedActivity lowItem = course.getLowest();
		System.out.println("Lowest score: " +
				lowItem.getScore());
	}
}
