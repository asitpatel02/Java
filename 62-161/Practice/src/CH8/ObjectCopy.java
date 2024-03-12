package CH8;
//Code Listing 8-11 pg#552

public class ObjectCopy {

	public static void main(String[] args) {

		//Create a stock object
		Stock company1 = new Stock("XYZ",9.62);

		//Declare a Stock Variable
		Stock company2 = new Stock("XYZ",9.62);

		//Make company2 reference a copy of the object referenced by company1
		//company2 = company1.copy();

		//Display the contents of both objects
		System.out.println("Company 1:\n" + company1);
		System.out.println();
		System.out.println("Company 2:\n" + company2);

		//Confirm that we actually have two object
		if (company1 == company2){
			System.out.println("The Company1 and Company2 variables reference the same object.");
		} else {
			System.out.println("The Company1 and Company2 variables reference different objects.");
		}
	}
}
