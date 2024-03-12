import java.util.Scanner;

public class MultiplicationTable {

    public static void main(String[] args) {

        System.out.print("Enter number of Multiplication Table: ");

        Scanner reader = new Scanner(System.in);

        int num = reader.nextInt();

        for (int i = 1; i<= 10; ++i)
        {
            System.out.printf("%d * %d = %d \n", num, i, num * i);
        }

    }
}