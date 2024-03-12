package Assignment_4;

public class CourseGradesDemo {

	public static void main(String[] args)
	{
		GradedActivity lab = new GradedActivity();
		// Set the lab score at 85.
		lab.setScore(85);

		// Create an object for the pass/fail exam.
		// 20 total questions, 3 questions missed, minimum
		// passing score is 70.
		PassFailExam PFE = new PassFailExam(20, 3, 70);

		// Create an object for the essay grade.
		Essay essay = new Essay();
		// Set the essay scores. Grammar = 25, spelling = 18
		// length = 17, content = 20.
		essay.setScore(25, 18, 17, 20);

		// Create an object for the final exam.
		// 50 questions, 10 missed.
		FinalExam finalExam = new FinalExam(50, 10);

		// Create a CourseGrades object.
		CourseGrades course = new CourseGrades();
		course.setLab(lab);
		course.setPassFailExam(PFE);
		course.setEssay(essay);
		course.setFinalExam(finalExam);

		// Display the scores and grades.
		System.out.println(course);
	}
}
