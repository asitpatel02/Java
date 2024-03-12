package CH7;// Code Listing 7-22 pg#510

public class VarargsDemo2 {

	public static void main(String[] args) {

		double total; //to hold the total balances

		//Create CH7.BankAccount object with $100
		BankAccount account1 = new BankAccount(100.0);

		//Create CH7.BankAccount object with $500
		BankAccount account2 = new BankAccount(500.0);

		//Create CH7.BankAccount object with $1500
		BankAccount account3 = new BankAccount(1500.0);

		//Call the method with one arguments
		total = totalBalance(account1);
		System.out.println("Total: $" + total);

		//Call the method with two arguments
		total = totalBalance(account1, account2);
		System.out.println("Total: $" + total);

		//Call the method with three arguments
		total = totalBalance(account1, account2, account3);
		System.out.println("Total: $" + total);
	}

	public static double totalBalance(BankAccount... accounts){

		double total = 0.0; // Accumulator

		//Add all the values in the accounts array

		for (BankAccount acctObject : accounts)
			total += acctObject.getBalance();

		// return the total
		return total;
	}
}
