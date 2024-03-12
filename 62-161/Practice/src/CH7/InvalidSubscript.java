package CH7;

// Code Listing 7-3
public class InvalidSubscript {
    public static void main(String[] args) {

        int[] values = new int[3];

        System.out.println("i will attempt to store four numbers in a there-element array.");

        for (int index = 0;index < 4;index++){
            System.out.println("now processing element "+index);
            values[index]= 10;
        }
    }
}
