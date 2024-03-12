package CH8;
//Code Listing 8-25 pg#583

import java.util.Scanner;

public class StockTrader {

	public static void main(String[] args) {

		int shareToBuy;     // Number of Shares to buy

		// Create a Stock object for the company stock.
		// The trading symbol is XYZ and the stock is currently $9.62 per share
		Stock xyzCompany = new Stock("XYZ",9.62);

		//Crate a Scanner object for keyBoard input
		Scanner keyboard = new Scanner(System.in);

		//Display the current share price
		System.out.printf("XYZ stock is currently $%,.2f.\n",xyzCompany.getSharePrice());

		//Get the number of shares to purchase
		System.out.print("Hoe many shares do you want to buy? ");
		shareToBuy = keyboard.nextInt();

		//Create a StockPurchase object fot the transaction
		StockPurchase buy = new StockPurchase(xyzCompany, shareToBuy);

		//Display the cost the transaction.
		System.out.printf("Cost of the Stock: $%,.2f",buy.getCost());
	}
}
