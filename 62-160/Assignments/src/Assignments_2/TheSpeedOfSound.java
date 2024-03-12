package Assignments_2;

import javax.swing.*;

public class TheSpeedOfSound {

    // Main
    public static void main(String[] args) {

        // String variables
        String userInput;
        String userINput;

        // Double variables
        double distance;
        double time = 0;

        //input air, water and steel
        userInput = JOptionPane.showInputDialog("Please enter the medium that your want the amount of time sound"+
                "travel in.\nPlease enter air, water or steel");

        //if statements
        if (userInput.equalsIgnoreCase("air") || userInput.equalsIgnoreCase("water") ||
        userInput.equalsIgnoreCase("steel")) {

            //input distance
            userINput = JOptionPane.showInputDialog("Please enter the distance that a sound wave will travel in " + userInput);
            distance = Double.parseDouble(userINput);

            if (userInput.equalsIgnoreCase("air")) {
                time = distance / 1100;
            } else if (userInput.equalsIgnoreCase("water")) {
                time = distance / 4900;
            } else if (userInput.equalsIgnoreCase("steel")) {
                time = distance / 16400;
            }

            //output
            JOptionPane.showMessageDialog(null, "It will take " + time + " for sound to travel " + distance + " in " + userInput);
        } else{

            //output
            JOptionPane.showMessageDialog(null,"Please enter a Valid calue. air, water, steel");
        }

        //exit
        System.exit(0);
    }
}
