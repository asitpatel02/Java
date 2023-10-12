
import java.util.Scanner;

/**
 *
 * @author 312679-shruti panchal
 */
public class PercentPassing {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numScore=0, maxScore;        
        double[] scores = new double[numScore];
        System.out.print("Score out of:: ");
        maxScore = in.nextInt();
        System.out.print("Number of Scores you want to add:: ");
        numScore = in.nextInt();
        
        for (int i=0;i<=numScore;i++){
            System.out.println("Score:: ");            
            scores[i] = in.nextDouble();                     
        }
        
    }
    
}
