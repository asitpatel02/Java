
import java.util.Scanner;

/**
 *
 * @author 312679
 */
public class Prompter {
    
    public static void main(String[] args) {
        int min, max, num;
        Scanner in = new Scanner(System.in);
        System.out.print("Input the min value:: ");
        min = in.nextInt();
        System.out.print("Input the max value:: ");
        max = in.nextInt();
        do {
            System.out.print("Input the number between the range:: ");
            num = in.nextInt();
        } while (num>max||num<min);  //!(num<max && num>min)
        System.out.println("In Range...");
    }
    
}
