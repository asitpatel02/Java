/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 312679-Shruti Panchal
 */
public class Sum {

    private double one,two;

    public Sum(double one, double two) {
        this.one = one;
        this.two = two;
        
    }

    public double getOne() {
        return one;
    }

    public double getTwo() {
        return two;
    }

    public double getSum() {
        return getOne()+getTwo();
    }
    
    public void setOne(double one) {
        this.one = one;
    }

    public void setTwo(double two) {
        this.two = two;
    }
       
//    public double calcSum() {
//        double sum = getOne() + getTwo();
//        return(sum);
//    }

    @Override
    public String toString() {
        return getOne()+" + "+getTwo()+" == "+String.format("%.3f", getSum())+"\n";
    }

    public static void main(String[] args) {
        Sum s1=new Sum(5.0,5.0);  
        Sum s2=new Sum(90.0,100.0);
        Sum s3=new Sum(100.5,85.8);
        
        System.out.println(s1);
        System.out.println(s2.toString());
        System.out.println(s3);
    }
    
}
