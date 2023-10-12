
import java.util.Scanner;

/**
 *
 * @author 312679-Shruti panchal I Love Appliances Oct 11 2019
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String output="";
        for (int i = 0; i < n; i++) {
            output = "Appliance "+in.next()+":/n";
            int price = in.nextInt();
            int a = in.nextInt();
            int x[] = new int[a];
            for (int j = 0; j < x.length; j++) {
                x[j] = in.nextInt();
            }

            for (int j = 0; j < x.length; j++) {
                if (x[j] < price) {
                    output+=("I love applications!/n");
                } else if (x[j] > price) {
                    output+=("You paid too much!/n");
                } else {
                    output+=("Wakkie Nu Nu!/n");
                }
            }
           output+="/n";
        }
        System.out.println(output);
    }//end main
}//end class
