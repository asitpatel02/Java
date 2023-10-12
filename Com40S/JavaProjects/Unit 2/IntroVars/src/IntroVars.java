
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 312679
 */
public class IntroVars {
    //variables declared here... outside of methods... are called INSTANCE VARIABLE
    // and use the scope PRIVATE
    private int num=10; //declares and initializes in 1 line
    private double total;   //declare
    private Color color;    //declare
    
    public void assignValues(){
        total=5.6;  //initializing
        color=Color.red;
        
        //output
        System.out.println(total);
        System.out.println(color);
        System.out.println(num);
        
        
    }
    
    public static void main(String[] args) {
        //output with no initializing the var's
        //System.out.println(num);
        IntroVars iv= new IntroVars();
        iv.assignValues();
    }
    
    
}
