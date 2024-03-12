import java.util.Scanner;

public class lab9Q1 {

    public static void showchar(String stringGiven, int integerGiven){
        if ((integerGiven < 0) || (integerGiven> stringGiven.length() - 1)){
            System.out.println("Please enter an index of 0 to last index of " + stringGiven + " which is " + (stringGiven.length() - 1));
        } else {

            System.out.println("The character at position " + integerGiven + " in " + stringGiven + " is " + stringGiven.charAt(integerGiven));
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String name;
        int num;

        System.out.println("Enter the Word: ");
        name = input.nextLine();

        System.out.println("Enter the position number: ");
        num = input.nextInt();

        showchar(name,num);
    }
}
