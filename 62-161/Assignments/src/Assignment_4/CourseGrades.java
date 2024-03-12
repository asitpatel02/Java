package Assignment_4;

public class CourseGrades implements Analyzable {

	public final int NUM_GRADES = 4;

	private final GradedActivity[] grades;

	public CourseGrades()
	{
		grades = new GradedActivity[NUM_GRADES];       // Creates an array grade of 4 GradedActivity object
	}

	public void setLab(GradedActivity aLab)
	{
		grades[0] = aLab;       // setLab which assigns the gradedActivity
	}

	public void setPassFailExam(PassFailExam aPassFailExam)
	{
		grades[1] = aPassFailExam;
	}

	public void setEssay(Essay anEssay)
	{
		grades[2] = anEssay;
	}

	public void setFinalExam(FinalExam aFinalExam)
	{
		grades[3] = aFinalExam;
	}

	public String toString()
	{
		return "Lab Score: " + grades[0].getScore() +
				"\tGrade: " + grades[0].getGrade() +
				"\nPass/Fail Exam Score: " + grades[1].getScore() +
				"\tGrade: " + grades[1].getGrade() +
				"\nEssay Score: " + grades[2].getScore() +
				"\tGrade: " + grades[2].getGrade() +
				"\nFinal Exam Score: " + grades[3].getScore() +
				"\tGrade: " + grades[3].getGrade();
	}

	public double getAverage() {
		double total = 0;
		for (GradedActivity grade : grades) {
			total += grade.getScore();
		}
		double average = total/ grades.length;
		return average;
	}

	public GradedActivity getHighest() {
		GradedActivity highest = grades[0];
		for (GradedActivity grade : grades) {
			if (grade.getScore() > highest.getScore())
				highest = grade;
		}
		return highest;
	}

	public GradedActivity getLowest() {
		GradedActivity lowest = grades[0];
		for (GradedActivity grade : grades) {
			if (grade.getScore() > lowest.getScore())
				lowest = grade;
		}
		return lowest;
	}
}