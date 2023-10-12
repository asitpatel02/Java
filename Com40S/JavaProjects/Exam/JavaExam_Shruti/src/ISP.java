
import java.util.Scanner;

/**
 *
 * @author 312679-Shruti Panchal JavaExam - ISP
 */
public class ISP {

    private double total = 0, hours = 0;
    private String pkg = "";
    private static final double A = 9.95;
    private static final double B = 13.95;
    private static final double C = 19.95;
    private static final int A_HOURS = 10;
    private static final int B_HOURS = 20;

    public ISP() {
        getInput();
        total = calcTotal(this.pkg, this.hours);
        System.out.println(this);
    }

    public void getInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Package choice (A, B, or C): ");
        pkg = in.next().toUpperCase();
        System.out.print("\nEnter the number of hours of access used: ");
        hours = in.nextInt();
        //System.out.println("");        

    }

    public double calcTotal(String pkg, double hours) {
        double t = 0;
        switch (pkg) {
            case "A":
                if (hours - A_HOURS > 0) {
                    t=(hours-A_HOURS)*2.00 + A;
                }else {
                    t=A;
                }
                break;
            case "B":
                if (hours - B_HOURS > 0) {
                    t=(hours-B_HOURS)*2.00 + B;
                }else {
                    t=B;
                }
                break;
            case "C":                
                    t=A;    
                    //change it to t=C;
                break;                      
        }
         return t;
    }

    @Override
    public String toString() {
        return "Total: $" + total;
    }        
}
