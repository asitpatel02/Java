import java.util.Scanner;

public class GCD {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("---Enter the positive number only---");
        System.out.print("Enter 1st Number:- ");
        int one = keyboard.nextInt();
        System.out.print("Enter 2nd Number:- ");
        int two = keyboard.nextInt();

        int n = gcd(one,two);
        System.out.println("GCD(" + one + "," + two + ") = " + n);
    }

    public static int gcd(int x,int y){
        if (y == 0) {
            return x;
        } else if (x>=y && y>0){
            return gcd(y,x%y);
        }else
            return gcd(y,x);
    }
}
