
import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 312679
 */
public class Cirlce {
    
    private static final double PI=3.14;
    
    public static void main(String[] args) {
        //input vars
    double radius;
    Scanner in = new Scanner(System.in);//used for input from keyboard
    
    //output vars
    double area,circumference;
        
    //input
        System.out.print("Enter a radius for your circle: ");
        radius = in.nextDouble();
        //radius - in from the keyboard the next double
        in.close(); // a nice thing to do
            
    //processing
    area=PI * Math.pow(radius, 2);
    circumference=2*PI*radius;
    
    //output
        System.out.println("Area is " + String.format("%.3f",area));
        System.out.println("Circumference is " + String.format("%.3f",circumference));
        //System.out.format("%.3f",radius); //#1
        //NumberFormat //#2
        //DecimalFormat numberFormat = new DecimalFormat("#.000");
        //System.out.println(numberFormat.format(radius));
    
    }
    
    
}
