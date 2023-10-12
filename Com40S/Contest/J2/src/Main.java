
import java.util.Scanner;

/**
 *
 * @author 312679 J2
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int[] n = new int[l];
        String[] s = new String[l];

        for (int i = 0; i < l; i++) {
            n[i] = in.nextInt();
            s[i] = in.next();
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < n[i]; j++) {
                System.out.print(s[i]);
            }
            System.out.println("");
        }

    }
}
