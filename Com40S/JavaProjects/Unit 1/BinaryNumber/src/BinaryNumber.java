/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 312679
 */
public class BinaryNumber {
    public static void main(String[] args) {
        int n = 0;
        System.out.format("%-15s %-15s","Decimal","Binary\n");
        
        //System.out.format("%-15s %-15s","1",Integer.toBinaryString(1));
         for (n = 0; n<=20 ; n++) {
        System.out.format("%-15s %-15s",n,Integer.toBinaryString(n));
             System.out.println("");
         }
        
    }
}
