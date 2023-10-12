import java.util.Scanner;
/*
 2. Write a short java function, isMultiple, that takes two long values, n and m, return true if and only if n is a multiple of m, that is ,
    n = m i for some integer i.

    Name : Asit Patel
    Student ID: 190309
 */
public class IsMultiple {

    // check if n is a multiple of m
    public static boolean isMultiple(long n, long m){
        return n % m == 0;
    }

    public static void main(String[] args) {
        long n, m;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the First Long value: ");
        n = scanner.nextInt();

        System.out.print("Enter the Second Long value: ");
        m = scanner.nextInt();

        System.out.println(n + " is a multiple of " + m + " is: " + isMultiple(n,m));
    }
}
