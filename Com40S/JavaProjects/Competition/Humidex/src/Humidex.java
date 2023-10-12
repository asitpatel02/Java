
import java.util.Scanner;

/**
 *
 * @author 312679-shruti panchal
 */
public class Humidex {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double D = in.nextDouble();
        double T = in.nextDouble();
       
        double  R = 6.11*Math.pow (Math.E, 5417.7530*( (1/273.16)-(1/273.16+D) )  );
        double H = 0.5555* (R-10.0);
        double humidex = T + H;
        System.out.println(humidex);
        
    }
    
}
