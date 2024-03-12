import java.util.Scanner;

public class Lab2 {

    public static int [] GreaterNumber(int [] integerArray, int number){

       int [] GreaterNumberToBeReturned = new int  [integerArray.length];
       int GreaterNumberToBeReturnedIndex = 0;

       for (int index = 0; index < integerArray.length; index++){
           if (integerArray[index]>number){
                GreaterNumberToBeReturned[GreaterNumberToBeReturnedIndex] = integerArray[index];
                GreaterNumberToBeReturnedIndex = GreaterNumberToBeReturnedIndex +1;
           }
       }
       return GreaterNumberToBeReturned;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int [] integerArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        System.out.print("Enter the Lager then Num: ");
        int N = input.nextInt();

        int [] GreaterNumberReturned = GreaterNumber(integerArray, N);

        for (int index = 0; index < GreaterNumberReturned.length; index++){
            if (GreaterNumberReturned[index]!=0) {
                System.out.println(GreaterNumberReturned[index]);
            }

        }
    }

}
