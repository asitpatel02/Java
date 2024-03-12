package CH8;
//Code Listing 8-21 pg#575

public class SportsCar {

	private CarType make;   // The car's make
	private CarColor color; // The car's color
	private double price;   // The Car's price

	/**
	 * the Constructor initializes the car's make
	 * color and price
	 * @param aMake the car's make
	 * @param aColor the car's color
	 * @param aPrice the car's price
	 */

	public SportsCar(CarType aMake, CarColor aColor, double aPrice){
		make = aMake;
		color = aColor;
		price = aPrice;
	}

	/**
	 * getMake method
	 * @return The Car's make
	 */

	public CarType getMake(){
		return make;
	}

	/**
	 * getcolor method
	 * @return The Car's make
	 */

	public CarColor getColor(){
		return color;
	}

	/**
	 * getPrice method
	 * @return The Car's make
	 */

	public double getPrice(){
		return price;
	}

	/**
	 * toString method
	 * @return A string indicating the car's make, color, and price
	 */

	public String toString(){
		//Create a string representing the object
		String str = String.format("Make: %s\nColor: %s\nPrice: $%,.2f", make, color, price);

		//Return the string
		return str;
	}
}