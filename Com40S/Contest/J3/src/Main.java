
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 312679 J3
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < s.length; i++) {
            s[i] = in.next();
        }
        int y = 1;
        String a = "";
//        ArrayList<Integer> a = new ArrayList<Integer>();
//        ArrayList<String> b = new ArrayList<String>();
        for (int i = 0; i < s.length; i++) {
//            char x = s[i].charAt(0);
            for (int j = 0; j < s[i].length() - 1; j++) {
                if (s[i].charAt(j) == s[i].charAt(j + 1)) {
                    y++;
                    if (j + 1 == s[i].length()-1) {
                        a = s[i].charAt(j) + "";
                        System.out.print(y + " " + a + " ");
                        //j--;
                        y = 1;
                    }
                } else {
                    a = s[i].charAt(j) + "";
                    System.out.print(y + " " + a + " ");
                    //j--;
                    y = 1;
                }
//                a=s[i].charAt(j)+"";     
                //                System.out.print(y + " "+a +" ");
                //                y=1;
                //            }
            }
            if (s[i].charAt(s[i].length() - 1) != s[i].charAt(s[i].length() - 2)) {
                System.out.print(y + " " + s[i].charAt(s[i].length() - 1));
            }
            System.out.println("");
        }
    }
}
//4
//+++===!!!!
//777777......TTTTTTTTTTTT
//(AABBC)
//3.1415555
