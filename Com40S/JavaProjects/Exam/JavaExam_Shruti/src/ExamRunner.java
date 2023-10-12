
import java.util.Scanner;

/**
 *
 * @author 312679-Shruti Panchal JavaExam - ExamRunner
 */
public class ExamRunner {

    private int choice = 0;

    public void run() {
        System.out.println("==========================");        
        System.out.println("Welcom to my exam programs");
        System.out.println("=========================="); 
        runProgram(menu());        
        
    }

    public static int menu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please select one of the following "
                + "options to view my programs: ");
        System.out.println("1: Rainfall");
        System.out.println("2: ISP");
        System.out.println("Any other number to exit");
        System.out.println("------------------------");
        System.out.print("Enter choice: ");         
        return(in.nextInt());
    }

    public void runProgram(int choice) {
        switch (choice) {
            case 1:
                RainFall r = new RainFall();
                System.out.println("------------------------");
                run();
                break;                
            case 2:
                ISP i = new ISP();
                System.out.println("------------------------");
                run();
                break;   
                
        }           
    }

    public static void main(String[] args) {
        ExamRunner shruti_Exam = new ExamRunner();
        shruti_Exam.run();
    }

}
