package Assignments_5;

public class SavingAccount {

    // private double variables
    private double AnnualInterestRate;
    private double balance;

    // void withdraw method
    public void withdraw(double userAmount){
        balance -= userAmount;
    }

    // void deposit method
    public void deposit(double userAmount){
        balance += userAmount;
    }

    // get method for balance
    public double getBalance(){
        return balance;
    }

    // interest method
    public double addMonthlyInterest(){

        // double variable for monthly interest rate
        double monthlyInterest;

        monthlyInterest = ((AnnualInterestRate / 12) * balance);
        balance += monthlyInterest;

        return monthlyInterest;
    }

    // annual interest rate method
    public void setAnnualInterestRate(double newRate){
        AnnualInterestRate = newRate;
    }

    // call to main method
    public SavingAccount( double startingBalance){
        balance = startingBalance;
        AnnualInterestRate = 0;
    }
}
