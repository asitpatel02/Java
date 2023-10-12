
import java.util.Scanner;

/**
 *
 * @author 312679-Shruti Panchal
 */
public class HeronsFormula {
    private int a,b,c;
    
    public HeronsFormula(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public double getS() {
        return getPerimeter()/2;
    }

    public double getPerimeter() {
        return getA()+getB()+getC();
    }

    public double getArea() {
        return Math.sqrt(getS()* (getS()-getA())* (getS()-getB())
                * (getS()-getC()));
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Triangle with sides: " + getA() + " " + getB() + " " + getC() +
                "\nArea == " + String.format("%.5f",getArea());
    }
    
    public static void main(String[] args) {
        HeronsFormula f1 = new HeronsFormula(3,3,3);
        System.out.println(f1);   
        
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the side A :: ");
        int a = in.nextInt();
        System.out.print("Enter the side B :: ");
        int b = in.nextInt();
        System.out.print("Enter the side C :: ");
        int c = in.nextInt();
        
        HeronsFormula f2 = new HeronsFormula(a,b,c);
        System.out.println(f2);
               
    }
    
}