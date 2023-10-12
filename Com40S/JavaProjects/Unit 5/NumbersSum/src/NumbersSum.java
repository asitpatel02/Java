
import java.util.Scanner;

/**
 *
 * @author 312679-shruti panchal
 */
public class NumbersSum {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num, sum=0;
        System.out.print("Enter a number:: ");
        num = in.nextInt();
        
        for (int i=0; i<=num;i++){
            sum+=i;
            System.out.println(i);           
        }
        System.out.println(sum);
    }
    
}
