/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 312679
 */
public class Formatting {
    public static void main(String[] args) {
        String s=" lkajgl";
        int x = 5;
        double z =5.6;
        final double PI = 3.4; // constant
        System.out.println("Teacher - Mrs. Klimack");
        System.out.format("%-20s %15s %15s","Student","Test 1","Test 2\n");
        System.out.format("%20s %15s %15s","Johnny","78","85\n");
        System.out.format("%20s %15d %15f","Ed",(int)((80-70+1)*Math.random()+70),85.6);
        System.out.println("");
        
        //random number formula
        //(int(high-low+1)*rnd+low)
        //rnd=Math.random()
        
    }
}
