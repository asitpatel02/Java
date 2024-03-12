import java.util.Scanner;

public class Average_Using_Arrays {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        System.out.println("How many number you have: ");
        double NumEnter = reader.nextDouble();


        double num[]=new double[(int) NumEnter];
        double average=0;
        int i=0;
        double sum=0.0;

        for (i=0;i<num.length;i++){
            System.out.print("Enter a number "+i+": ");
            num[i]=reader.nextDouble();
            sum=sum+num[i];
        }
        average=sum/10;
        System.out.println("Average= "+average);
    }
}
