
import java.util.Scanner;

public class lab4Q2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double cookies = 48;
        double sugar = 1.5;
        double butter = 1;
        double flour = 2.75;

        double total_sugar, total_flour, total_butter;
        int num_cookies;

        System.out.println("How many cookies do you want to make?");
        num_cookies=input.nextInt();

        total_butter = (butter * num_cookies)/cookies;
        total_flour = (flour * num_cookies)/cookies;
        total_sugar = (sugar * num_cookies)/cookies;

        System.out.println("To make "+num_cookies+" cookies");
        System.out.println("you will need the following ingredients");
        System.out.print("cups of butter:- ");
        System.out.printf("%.2f%n",total_butter);
        System.out.print("cups of sugar:- ");
        System.out.printf("%.2f%n",total_sugar);
        System.out.print("cups of flour:- ");
        System.out.printf("%.2f%n",total_flour);
    }
}