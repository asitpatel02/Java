package CH8;
//Code Listing 8-22 pg#576

public class SportsCarDemo {

	public static void main(String[] args) {
		//Create a SportsCar object
		SportsCar yourNewCar = new SportsCar(CarType.PORSCHE,CarColor.RED,10000);

		//Display the object value
		System.out.println(yourNewCar);
	}
}
