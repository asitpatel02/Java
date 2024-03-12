package CH7;// Code Listing 7-16 page No: 485

import java.util.Scanner;

public class ObjectArray {

    public static void main(String[] args) {

        final int NUM_ACCOUNTS = 3; // Numbers of Accounts

        // Create an array that can reference
        // Bank account objects
        BankAccount[] accounts = new BankAccount[NUM_ACCOUNTS];

        // Create objects for the array
        createAccounts(accounts);

        //Display the balances of the each amount
        System.out.println("Here are the balances for each account: ");

        for (int index = 0; index < accounts.length; index++){
            System.out.println("Account " + (index + 1) + ": $" + accounts[index].getBalance());
        }
    }

    private static void createAccounts(BankAccount[] array){

        double balance; // to hold an account balance

        // Create a Scanner object
        Scanner keyboard = new Scanner(System.in);

        //Create the accounts
        for (int index = 0; index < array.length; index++){
            // get the account's balance
            System.out.print("Enter the balance for account " + (index + 1) + ": ");
            balance = keyboard.nextDouble();

            //Crate the account
            array[index] = new BankAccount(balance);
        }
    }
}