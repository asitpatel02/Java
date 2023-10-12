
import java.util.Scanner;

/**
 *
 * @author 312679-shruti panchal
 */
public class KnuthsUpArrow {
 
    public static void main(String[] args) {
      
        double result = 0;
        
        Scanner in = new Scanner (System.in);
        System.out.println("Enter ::" );
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        result = num1;
        
        for (int i = 0; i < num2 - 1; i++) {
            result = Math.pow(num1, result); //does the math
        }
        
        System.out.println(result);
     
    }//end main
    
}//end class
