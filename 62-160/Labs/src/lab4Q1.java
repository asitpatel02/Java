
public class lab4Q1 {
    public static void main(String[] args) {

        // pi square
        double x;
        x=Math.pow(Math.PI,2);
        System.out.print("Pi square is: ");
        System.out.printf("%.2f%n",x);

        // n root of a
        double y;
        y=Math.pow(Math.PI,0.25);
        System.out.print("4 roots of PI: ");
        System.out.printf("%.2f%n",y);

        // E
        double z;
        z=Math.pow(Math.E,Math.PI);
        System.out.print("E power of pi is: ");
        System.out.printf("%.2f%n",z);

        double a;
        a=Math.pow(Math.E,y);
        System.out.print("E power of 4 roots of PI: ");
        System.out.printf("%.2f%n",a);

        double b;
        b=Math.pow(Math.PI,Math.E);
        System.out.print("PI power of E: ");
        System.out.printf("%.2f%n",b);

    }
}