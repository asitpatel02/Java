package CH7;

// Code Listing 7-7
public class SameArray {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array2 = array1;

        // change onr of elements using array1
        array1[0] = 1100;
        array1[2] = 3600;

        // change one of elements using array2
        array2[5] = 5500;

        // Display all the elements using array1
        System.out.println("The Contents of array1: ");
        for (int value : array1)
            System.out.print(value + " ");
        System.out.println();

        // Display all the elements using array2
        System.out.println("The Contents of array2: ");
        for (int value : array2)
            System.out.print(value + " ");
    }
}
