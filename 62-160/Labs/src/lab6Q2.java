
import java.util.Scanner;

public class lab6Q2 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int time;
        double total = 0.0;

        // Store the package and rates in variables
        double packageA = 39.99;
        double packageB = 59.99;
        double packageC = 69.99;
        double rateD = 0.45;
        double rateE = 0.40;

        char pack;

        System.out.println("A. Package A: for $39.99 per month, 450 minutes are provided. additional minutes are $0.45 per minute.");
        System.out.println("B. package B: for $59.99 per month, 900 minutes are provided . additional minutes are $0.40 per minutes.");
        System.out.println("C. package C: for $69.99 per month, unlimited minutes are provided.");
        System.out.print("Select a subscription package A, B & C. :-");
        pack = input.next().charAt(0);

        //Validation
        if (pack == 'A' || pack == 'a' || pack == 'B' || pack == 'b' || pack == 'C' || pack == 'c') {


            System.out.print(" How many minutes were used? :- ");
            time = input.nextInt();

            switch (pack) {
                case ('A' | 'a'): {
                    if (time < 450) {
                        total =  packageA;
                    } else {
                        total = ((time - 450) * rateD) + packageA;
                    }
                    break;
                }
                case ('B' | 'b'): {
                    if (time < 900) {
                        total = packageB;
                    } else {
                        total = ((time - 900) * rateE) + packageB;
                    }
                    break;
                }
                case ('C' | 'c'): {
                    total = packageC;
                    break;
                }

            }
            System.out.println("Total amount due is: $ " + total);
        }else{
            System.out.println("Package must be A, B, or C. ");
            System.exit(0);
        }
    }
}