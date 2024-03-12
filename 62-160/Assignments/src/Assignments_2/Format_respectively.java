package Assignments_2;



public class Format_respectively {

    // Main
    public static void main(String[] args) {

        // Double Variable
        double num1 = 1234567.456;
        double num2 = 123.456;
        double num3 = 123.456;
        double num4 = 123456.789;

        // Int Variable
        int num5 = 123456;

        // String Variable
        String name = "James";

        // 1st Statement output
        System.out.printf("statement 1st: %,.2f",num1);

        // 2nd Statement output
        System.out.printf("\nStatement 2nd: %10.1f",num2);

        // 3rd Statement output
        System.out.printf("\nStatement 3rd: %08.1f",num3);

        // 4th Statement output
        System.out.printf("\nStatement 4th: %-,20.2f",num4);

        // 5th Statement output
        System.out.printf("\nStatement 5th: %10d",num5);

        // 6th Statement output
        System.out.printf("\nStatement 6th: %20s",name);

        // Exit
        System.exit(0);
    }
}
