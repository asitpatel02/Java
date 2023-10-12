
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
public class SimpleInterest {
    //instance vars
    private double principal, interestRate;
    private int years;

    //constructor
    public SimpleInterest(double principal, int years, double interestRate) {
        setPrincipal(principal);
        setInterestRate(interestRate);
        setYears(years);
    }

    //setters
    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setYears(int years) {
        this.years = years;
    }

    //getters
    public double getPrincipal() {
        return principal;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getYears() {
        return years;
    }

    //calculation
    public double calcInterest(){        
        return(principal*(1+years * interestRate));
    }
    
    //output toString()
    @Override
    public String toString() {
        //return "SimpleInterest{" + "principal=" + principal + ", interestRate=" + interestRate + ", years=" + years + '}';        
        NumberFormat numFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
        return "The value after the term is: " + numFormat.format(this.calcInterest());
    }
    
    //main
    public static void main(String[] args) {
        
        SimpleInterest interest1 = new SimpleInterest(5000,5,0.06);
        //System.out.println(interest1.calcInterest());
        
        //get input from user
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the Principal: ");
        double principal = in.nextDouble();        
        System.out.print("Enter the years: ");
        int years = in.nextInt();
        System.out.print("Enter the Interest Rate: ");
        double interestRate = in.nextDouble();
        in.close();
        
        //NumberFormat numFormat = NumberFormat.getCurrencyInstance(new Locale("en", "US"));        
        //System.out.println("The value after the term is: "+ numFormat.format(interest1.calcInterest()));
        
        System.out.println(interest1);
    }
    
    
}
