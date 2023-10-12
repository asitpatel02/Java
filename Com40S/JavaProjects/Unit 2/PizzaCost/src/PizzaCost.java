
import java.text.NumberFormat;
import java.util.Locale;
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
public class PizzaCost {
    
    private static final double labourCost = 0.75;
    private static final double rentCost = 1.00;
    private static final double materials = 0.05;
    
              
    public static void main(String[] args) {
        
        //input vars
        int diameter;
        String name;
        String phoneNumber;
        
        Scanner in = new Scanner(System.in);
        
        //output vars
        double pizzaCost;
        
        //input
        System.out.print("Enter your name: ");
        name=in.nextLine();          
        
        System.out.print("Enter your phone number: ");
        phoneNumber=in.nextLine();
        
        System.out.print("Enter the diameter of the pizza in inches: ");
        diameter=in.nextInt();
        
        in.close();
        
        //processing        
        pizzaCost=labourCost+rentCost+(materials*diameter*diameter);
                
        //output
        System.out.println(name + " The cost of making your pizza is: " + 
                NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(pizzaCost));
    }
    
}
