import java.util.Scanner;

public class lab3Q2 {
    public static void main(String[] args) {
        double male, female, total;
        double MApercentage, FApercentage;
        Scanner ma = new Scanner(System.in);
        System.out.print("Enter your number of male students in your class: ");
        male=ma.nextInt();
        System.out.print("Enter Your number of female students in your class: ");
        female=ma.nextInt();
        total=male + female;
        MApercentage=(male/total*100);
        FApercentage=(female/total*100);
        System.out.println("Male students Percentage is %"+MApercentage);
        System.out.println("Female students Percentage is %"+FApercentage);
        System.out.println("Number of total students in your class is "+total);
    }
}