/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 312679
 */
public class Skaters {
    private char[] skaters = {'P','Q','R','S','T','U','V'};    
    private char[] skaterMove= {'P','Q','R','S','T','U','V'};
    public static void main(String[] args) {
        Skaters s1 = new Skaters();
        int min=60;        
        int move=min%7;
        //System.out.println(move);
        for (int i=0;i<s1.skaters.length;i++) {
            if ((i+move)<7){
            s1.skaterMove[i+move]=s1.skaters[i];
            }
            else {
                s1.skaterMove[i+move-7]=s1.skaters[i];
                //System.out.println(i+move-7);
            }                      
        }      
        for (int i=0;i<s1.skaters.length;i++) {
            System.out.println(s1.skaterMove[i]);
        }
    }
}
