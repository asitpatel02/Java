package Assignments_3;

import java.util.Scanner;

public class Distance_Travelled {

    // Main
    public static void main(String[] args) {

        // Scanner for input integers
        Scanner keyboard = new Scanner(System.in);

        // Int Variables
        int timeTravelled = 0;

        // Double Variables
        double VehicleSpeed = -1;
        double distanceTravelled;

        // Validation for Speed
        while ( VehicleSpeed < 0 ) {
            System.out.print("Please enter your the speed of the Vehicle (in miles-per-hour): ");
            VehicleSpeed = keyboard.nextDouble();
        }

        // Validation for Time
        while (timeTravelled < 1) {
            System.out.print("Please enter the number of hours the vehicle has travelled: ");
            timeTravelled = keyboard.nextInt();
        }

        // Output
        System.out.println();
        System.out.println("Hour\tDistance Travelled\n----\t------------------");
        for( int hour = 1; hour <= timeTravelled; hour++){
            distanceTravelled = (hour * VehicleSpeed);
            System.out.println(" " + hour + "\t\t\t" +(int) distanceTravelled + " MpH");
        }

        // Exit
        System.exit(0);
    }
}