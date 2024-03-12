package CH8;
//Code Listing 8-23 pg#577

public class SportsCarDemo2 {

	public static void main(String[] args) {

		//Create a SportsCar object
		SportsCar yourNewCar = new SportsCar(CarType.PORSCHE, CarColor.RED, 123456);

		System.out.println(yourNewCar);

		//get the car make and switch on it
		switch (yourNewCar.getMake()){
			case PORSCHE :
				System.out.println("your car was made in Germany");
				break;
			case FERRARI:
				System.out.println("your car was made in Italy");
				break;
			case JAGUAR:
				System.out.println("your car was made in England");
				break;
			default:
				System.out.println("i'm not sure where that car was made.");
		}
	}
}
