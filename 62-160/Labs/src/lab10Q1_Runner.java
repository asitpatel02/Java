public class lab10Q1_Runner {

    public static void main(String[] args) {
        lab10Q1 car = new lab10Q1();

        System.out.println("Current status of the car:-");
        System.out.println("\n\tYear Model: " + car.getYearModel());
        System.out.println("\tMake: " + car.getMake());
        System.out.println("\tSpeed: " + car.getSpeed());

        System.out.println("\nAccelerating......");

        // for loop
        for (int seconds = 1; seconds <=5; seconds++){
            car.Accelerate();
            System.out.println("\tNow the speed is " + car.getSpeed() + " km/h");
        }

        System.out.println("\nBraking......");

        // do-while loop
        int times = 1;
        do {
            car.Break();
            System.out.println("\tNow the speed is " + car.getSpeed() + " km/h");
            times++;
        }
        while (times <=5);

        System.exit(0);
    }
}