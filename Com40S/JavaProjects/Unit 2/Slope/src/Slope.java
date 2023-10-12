
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
public class Slope {
    public static void main(String[] args) {
        
        //input vars
        int x1,x2,y1,y2;        
        Scanner in = new Scanner(System.in);
        
        //output vars
        int m;
        
        //input            
        System.out.print("Enter the x1 point: ");
        x1=in.nextInt();
        System.out.print("Enter the x2 point: ");
        x2=in.nextInt();
        System.out.print("Enter the y1 point: ");
        y1=in.nextInt();
        System.out.print("Enter the y2 point: ");
        y2=in.nextInt();
        in.close();
        
        //processing        
        m=(y2-y1)/(x2-x1);
        
        //output
        System.out.println("The slope of the line is: " + m);
    }
        
        
    
}
