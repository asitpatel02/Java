
import java.util.Scanner;

/**
 *
 * @author 312679 J4
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int h = 0, v = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'V') {
                v++;
            } else if (s.charAt(i) == 'H') {
                h++;
            }
        }
        //System.out.println(h + "  " + v);
        if (h % 2 == 0) {
            h = 0;
        } else {
            h = 1;
        }
        if (v % 2 == 0) {
            v = 0;
        } else {
            v = 1;
        }
        //System.out.println(h + "  " + v);
        if (h > 0 && v > 0) {
            System.out.println("4 3\n2 1");
        } else if (h > 0 && v == 0) {
            System.out.println("3 4\n1 2");
        } else if (h == 0 && v > 0) {
            System.out.println("2 1\n4 3");
        } else {
            System.out.println("1 2\n3 4");
        }
    }
}
