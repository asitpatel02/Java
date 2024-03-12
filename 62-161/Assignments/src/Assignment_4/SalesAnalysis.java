package Assignment_4;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SalesAnalysis {

	public static void main( String[]args )  throws IOException {

		String input;                           // To hold a line from the file:
		double salesWeek;
		double average;
		double total = 0.0;
		double highestSales = 0.0;
		double lowestSales = 0.0;
		double highest = 0;
		double lowest = 0;
		int weekNumber = 0;

		DecimalFormat dollar = new DecimalFormat("#,##0.00");       // Create a DecimalFormat object:

		File file = new File("SalesData.txt");                      // Open the SalesData.txt file.
		Scanner inputFile = new Scanner(file);

		while ( inputFile.hasNext() ) {

			input = inputFile.nextLine();                           // Read a line from the file.
			weekNumber++;

			salesWeek = getWeeklySales( input );

			System.out.print("Week " + weekNumber + " sales: $" + dollar.format(salesWeek));
			System.out.println("\tAverage daily sales for week " + weekNumber + ": $" + dollar.format(salesWeek / 7.0));

			total = total + salesWeek;
			// Find the highest and lowest
			if( weekNumber == 1 ) {
				highest = 1;
				highestSales = salesWeek;
				lowest = 1;
				lowestSales = salesWeek;
			}else{
				if( salesWeek > highestSales ) {
					highest = weekNumber;
				} if( salesWeek < lowestSales ) {
					lowest = weekNumber;
				}
			}
		}

		inputFile.close();                                // Close the file:

		average = total / weekNumber;

		System.out.println("Total sales for all weeks: $" + dollar.format(total));
		System.out.println("Average weekly sales: $" + dollar.format(average));
		System.out.println("The highest sales were made during " + "week " + highest + ".");
		System.out.println("The lowest sales were made during " +  "week " + lowest + ".");
	}

	public static double getWeeklySales( String str ) {
		double weekTotal = 0.0;

		StringTokenizer strToken = new StringTokenizer(str, "," );

		while( strToken.hasMoreTokens() ) {
			weekTotal =  weekTotal + Double.parseDouble( strToken.nextToken() );

		}

		return weekTotal;
	}
}