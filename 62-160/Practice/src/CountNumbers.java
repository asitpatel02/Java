import java.util.Scanner;

public class CountNumbers {

    public static void main(String[] args) {

        System.out.print("Enter the number: ");

        Scanner reader = new Scanner(System.in);
        int num= reader.nextInt();
        int num2 = num;

        // using while loop
        int count = 0;
        while (num !=0){
            num /=10;
            ++count;
        }

        System.out.println("Number of digits Using while loop: " + count);

        // using for loop
        int count2 = 0;
        for (; num2!=0; num2/=10, ++count2){
        }

        System.out.println("Number of digits Using for loop: " + count2);

    }
}
