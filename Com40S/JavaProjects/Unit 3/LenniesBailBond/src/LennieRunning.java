/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 312679
 */
public class LennieRunning {
    
    public static void main(String[] args) {
        Lennie mitchell = new Lennie(5000);
        mitchell.setCollateral("House");
        System.out.println(mitchell);
        mitchell.displayInfo();
        Lennie l1 = new Lennie(12000);
        l1.setCollateral("Car");
        l1.displayInfo();
        
    }
   
}
