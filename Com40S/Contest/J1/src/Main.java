
import java.util.Scanner;


/**
 *
 * @author 312679
 * J1
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[3];
        int[] b = new int[3];
        for (int i = 0; i < a.length; i++) {
            a[i]=in.nextInt();
        }
        for (int i = 0; i < b.length; i++) {
            b[i]=in.nextInt();
        }
        int a3,a2,a1,b3,b2,b1;
        a3=a[0]*3;
        a2=a[1]*2;
        a1=a[2];
        b3=b[0]*3;
        b2=b[1]*2;
        b1=b[2];
        int tA=a3+a2+a1;
        int tB=b3+b2+b1;
        if (tA>tB) {
            System.out.println("A");
        } else if (tB>tA) {
            System.out.println("B");
        }else
            System.out.println("T");
    }
    
}
