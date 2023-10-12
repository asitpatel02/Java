
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
public class Change {
    
    private static final int Quarter = 25;
    private static final int Dime = 10;
    private static final int Nickel = 5;
    private static final int Penny = 1;
    
    
    public static void main(String[] args) {
        
        //input vars
        int cents;
        Scanner in = new Scanner(System.in);
        
        //output vars
        int quarter;
        int dime;
        int nickel;
        int penny;
        
        boolean x=true;
             boolean   y=true;
        
        //input
        System.out.print("Enter the cents: ");
        cents=in.nextInt();
        in.close();
        
        //process       
        quarter=cents/Quarter;
        cents=cents%Quarter;
        dime=(cents)/Dime;
        cents=cents%Dime;
        nickel= (cents)/Nickel;
        cents=cents%Nickel;
        penny=(cents%Nickel)/Penny;        
        
        //output        
        System.out.println("Quarter(s)\t" + quarter);
        System.out.println("Dime(s)\t\t" + dime);
        System.out.println("Nickel(s)\t"+nickel);
        System.out.println("Penny(s)\t"+penny);        
        System.out.println(!x);
        System.out.println(!(!x & y));
        if ((!x && y) || !(!x || y)){
            System.out.println("true");
        }
       float f = 9.87f;
       double w =102.0;
       w=f;
       System.out.println(f);
        System.out.println(System.currentTimeMillis());
    }
    
}
