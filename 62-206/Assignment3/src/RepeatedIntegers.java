import java.util.Scanner;

public class RepeatedIntegers {
    public void print(int[] a, int s)
    {
        int[] n = new int[s];
        int i;
        System.out.print("Repeated integers are: ");
        for(i=0; i<s; i++)
        {
            if(n[a[i]] == 1)
                System.out.print( a[i]+" ");
            else
                n[a[i]]++;
        }
    }
    public static void main(String[] args) {

        RepeatedIntegers obj = new RepeatedIntegers();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        int count = 1;
        System.out.println("---Enter the Elements in Array / Please enter one element per one line---");
        for(int i=0; i<n; i++) {
            System.out.print("Enter the " + count + " number integers: ");
            array[i] = scanner.nextInt();
            count++;
        }
        System.out.println();
        obj.print(array, n);
    }
}
