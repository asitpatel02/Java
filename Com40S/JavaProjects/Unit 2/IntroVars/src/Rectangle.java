
import java.awt.Color;
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
public class Rectangle {
    
    public static void main(String[] args) {
        //vars declared inside methods are LOCAL to the method
        
        //input vars
        int length;
        int width;
        Color color;
        Scanner in = new Scanner(System.in);
               
        //output vars
        int area;
        int perim;
        
        //input
        System.out.print("Enter length for your rectangle: ");        
        length=in.nextInt();
        
        System.out.print("Enter width for your rectangle: ");
        width=in.nextInt();
        in.close();
        
        //processing
        area=length*width;
        perim=2*length+2*width;
        
        //output
        System.out.println("Area is " + area);
        System.out.println("Perimeter is " + perim);
        
    }
}
