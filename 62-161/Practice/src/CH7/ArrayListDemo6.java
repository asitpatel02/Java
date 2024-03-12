package CH7;//Code Listing 7-27 pg#518

import java.util.ArrayList;

public class ArrayListDemo6 {

	public static void main(String[] args) {

		//Create an ArrayList to hold CH7.BankAccount objects.
		ArrayList<BankAccount> list = new ArrayList<BankAccount>();

		//Add three CH7.BankAccount object to the Arraylist
		list.add(new BankAccount(100.0));
		list.add(new BankAccount(500.0));
		list.add(new BankAccount(1500.0));

		//Display each item
		for (int index = 0; index < list.size(); index++) {
			BankAccount account = list.get(index);
			System.out.println("Account at index " + index + " \nBalance: " + account.getBalance());
		}
	}
}