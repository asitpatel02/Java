package CH8;
//Code Listing 8-10 pg#550

public class StockCompare {

	public static void main(String[] args) {

		//Create two Stock object with the same value
		Stock company1 = new Stock("XYZ",9.62);
		Stock company2 = new Stock("XYZ",9.62);

		//Use the equal method to compare the objects
		if (company1.equals(company2)){
			System.out.println("Both objects are the same.");
		} else {
			System.out.println("The objects are different.");
		}
	}
}
