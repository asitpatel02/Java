package CH8;
// Code Listing 8-7 pf#542

import CH7.BankAccount;

import javax.swing.*;

public class ReturnObject {

	public static void main(String[] args) {

		BankAccount account;

		// gert a reference to a BankAccount object
		account = getAccount();

		//Display the account balance
		JOptionPane.showMessageDialog(null, "The account has a balance of $" + account.getBalance());

		System.exit(0);
	}

	public static BankAccount getAccount(){

		String input; // to hold input
		double balance; // Account balance

		// get the balance from the user
		input = JOptionPane.showInputDialog("Enter the account balance.");
		balance = Double.parseDouble(input);

		//Create a BankAccount Object and return a reference to it
		return new BankAccount(balance);
	}
}
