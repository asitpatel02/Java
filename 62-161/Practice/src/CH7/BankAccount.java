package CH7;// Code Listing 6-20 page no: 412

public class BankAccount {

    private double balance; // account balance

    public BankAccount() {
        balance = 0.0;
    }

    public BankAccount(double startBalance) {
        balance = startBalance;
    }

    public BankAccount(String str) {
        balance = Double.parseDouble(str);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void deposit(String str) {
        balance += Double.parseDouble(str);
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void withdraw(String str) {
        balance -= Double.parseDouble(str);
    }

    public void setBalance(double b) {
        balance = b;
    }

    public void setBalance(String str) {
        balance = Double.parseDouble(str);
    }

    public double getBalance() {
        return balance;
    }
}