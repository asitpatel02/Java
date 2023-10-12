
/**
 *
 * @author 312679-Shruti Panchal
 */
public class GradeCheck {

    private int numGrade;

    public GradeCheck() {
        numGrade = 0;
    }

    public GradeCheck(int grade) {
        setGrade(grade);
    }

    public void setGrade(int grade) {
        numGrade = grade;
    }

    public String getLetterGrade() {
        String letGrade = "";
        if (numGrade>=90)letGrade="A";
        else if(numGrade >=80)letGrade="B";
        else if(numGrade >=75)letGrade="C";
        else if(numGrade >=70)letGrade="D";
        else letGrade="F";

        return letGrade;
    }

    @Override
    public String toString() {
        return numGrade + " is a " + getLetterGrade() + "\n";
    }
    
    public static void main(String[] args) {
        GradeCheck g1 = new GradeCheck(98);
        System.out.println(g1);
        GradeCheck g2 = new GradeCheck(80);
        System.out.println(g2);
        GradeCheck g3 = new GradeCheck(75);
        System.out.println(g3);
        GradeCheck g4 = new GradeCheck(72);
        System.out.println(g4);
        GradeCheck g5 = new GradeCheck(45);
        System.out.println(g5);
        
    }
    
}
