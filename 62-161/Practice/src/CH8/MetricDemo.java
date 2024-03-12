package CH8;
//Code Listing 8-4 pg#537

import javax.swing.*;

public class MetricDemo {

	public static void main(String[] args) {

		String input; // to hold input
		double miles; // a distance in miles
		double kilos; // a distance in kilometers

		// get a distance in miles
		input = JOptionPane.showInputDialog("Enter a distance in miles.");
		miles = Double.parseDouble(input);

		//Convert the distance to kilometers
		kilos = Metric.milesToKilometers(miles);
		JOptionPane.showMessageDialog(null, String.format("%,.2f miles equal %,.2f kilometers.",miles,kilos));

		//get a distance in kilometers
		input = JOptionPane.showInputDialog("Enter a distance in kilometers: ");
		kilos = Double.parseDouble(input);

		// Convert the distance in kilometers
		miles = Metric.kilometersToMiles(kilos);
		JOptionPane.showMessageDialog(null, String.format("%,.2f kilometers equal %,.2f miles.",kilos,miles));

		System.exit(0);
	}
}
