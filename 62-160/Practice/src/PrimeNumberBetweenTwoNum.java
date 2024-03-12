import java.util.Scanner;

public class PrimeNumberBetweenTwoNum {

    public static void main(String[] args) {

        System.out.println("Display Prime Number Between Two Intervals");

        Scanner reader = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        int low = reader.nextInt();

        System.out.print("Enter second number: ");
        int high = reader.nextInt();

        while (low<high)
        {
            boolean flag  = false;

            for(int i = 2; i <= low/2; ++i){
                // condition for nonprime number
                if(low % i == 0){
                    flag = true;
                    break;

                }
            }

            if (!flag && low !=0 && low != 1)
                System.out.print(low + " ");

            low++;
        }
    }
}
