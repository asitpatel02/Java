package CH7;

import javax.swing.*;

// Code Listing 7-11 page no. 470 it's connected to CH7.SalesData
public class Sales {

    private static void getValues(double[] array){

        String input; // to hold user input

        // get sa;es fpr each day of the week
        for (int i = 0; i < array.length; i++){
            input = JOptionPane.showInputDialog("Enter the sales for day " + (i + 1) + ".");
            array[i] = Double.parseDouble(input);
        }
    }

    public static void main(String[] args) {

        final int ONE_WEEK = 7; // Number of elements

        //  Create an array to hold sales amounts for a week.
        double[] sales = new double[ONE_WEEK];

        // Get the week's sales figures.
        getValues(sales);

        // Create a sales data object, initialized
        // with the week's sales figures.
        SalesData week = new SalesData(sales);

        // Display the total, average, highest, and lowest
        // sales amount for the week.
        JOptionPane.showMessageDialog(null, String.format("The total sales were $%,.2f\n" +
                                                                        "The average sales were $%,.2f\n" +
                                                                        "The highest sales were $%,.2f\n" +
                                                                        "The lowest sales were $%,.2f\n",
                                                                        week.getTotal(),
                                                                        week.getAverage(),
                                                                        week.getHighest(),
                                                                        week.getLowest()));

        System.exit(0);
    }
}