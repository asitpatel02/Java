
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
public class SlopeRunner {
    
    public static void main(String[] args) {
        Slope s1=new Slope(7,10,-12,5);
        System.out.println("Slope of s1: " + s1.calcSlope());
        
        s1.setX1(9);
        System.out.println("Slope of s1: " + s1.calcSlope());
        
        //get input from user
        Scanner in = new Scanner(System.in);
        System.out.print("Enter y1:");
        double y1 = in.nextDouble();
        s1.setY1(y1);
        System.out.println("Slope of s1: " + s1.calcSlope());
        
        //output
        int x=9;
        System.out.println("X:" +x);
        
        System.out.println(s1);
    }
}
