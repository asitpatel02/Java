package CH7;

// Code Listing 7-8
public class PassElements {

    public static void main(String[] args) {

        int[] Numbers = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};

        for (int index = 0; index < Numbers.length; index++)
            showValue(Numbers[index]);
    }

    public static void showValue(int n){
        System.out.print(n + " ");
    }
}