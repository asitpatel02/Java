package Assignment_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PopulationData {

    private static int GetMinimumIncreaseYear(int[] Population){

        // Calculate minimum Population for 1950 and 1951
        int MinPopulation = Population[1] - Population[0];

        //Assume that 1950 is the minimum Population Year
        int MinYear = 1950;
        for (int Year = 1; Year < Population.length - 1; Year++){

            // Calculate the change in Population
            int PopChange = Population[Year+1] - Population[Year];

            // Check if Population change is greater then maximum Population
            if (PopChange<MinPopulation){

                //set maximum Population
                MinPopulation = PopChange;
                //Update MinYear
                MinYear = MinYear + Year;
            }
        }
        //return MinYear
        return MinYear;
    } // close GetMinimumIncreaseYear

    private static int GetMaximumIncreaseYear(int[] Population){

        //Calculate max Population
        int MaxPopulation = Population[1] - Population[0];

        //Assume that 1950 is the maximum Population Year
        int MaxYear = 1950;

        for (int Year = 1; Year < Population.length - 1; Year++){

            // Calculate the change in Population
            int PopChange = Population[Year+1] - Population[Year];

            // Check is Population change is greater than maximum Population
            if (PopChange>MaxPopulation){

                // set maximum Population
                MaxPopulation = PopChange;
                // update MaxYear
                MaxYear = MaxYear + Year;
            } // close if statement 
        } // close for loop
        //Return MaxYear
        return MaxYear;
    } // close GetMaximumIncreaseYear

    private static double AverageAnnualChange(int[] Population){

        //set variable, ChangeInPopulation
        double ChangeInPopulation = 0;

        for (int i = 0; i < Population.length-1; i++){
            ChangeInPopulation += Population[i+1] - Population[1];
        } // close for loop

        //Return Average annual change
        return ChangeInPopulation/Population.length;
    } // CLose AverageAnnualChange

    public static void main(String[] args) {
        // Declare a Scanner class variable
        String pathname ="USPopulation.txt";
        // Scanner FileReader=null
        //set a file name

        // Number of Years from 1950-1990 1990-1950+1=41*/
        // set a constant from number of Year
        final int numYear = 41;
        
        // declare an array of type integer
        int[] Population = new int[numYear];

        //Set Year index to zero
        int Year = 0;

        // Open text file "USPopulation.txt"
        try {

            //Open a file using Scanner class constructor
            Scanner FileReader = new Scanner(new File(pathname));

            // Read Population from file
            while (FileReader.hasNextInt()){

                //read Population from file
                Population[Year] = FileReader.nextInt();
                //increment Year by one
                Year++;
            } // close while argument

            // Close the FileReader object
            FileReader.close();

            double avgChange = AverageAnnualChange(Population);
            System.out.printf("Average annual change in Population: %.2f\n",avgChange);

            //call method getMaximum IncreaseYear with Population
            int MaxYear = GetMaximumIncreaseYear(Population);
            System.out.println("Year with maximum Population increase: " + MaxYear);

            //call method GetMinimumIncreaseYear with Population array
            int MinYear = GetMinimumIncreaseYear(Population);
            System.out.println("Year with minimum Population increase: " + MinYear);
        } // close try
        //Catch the exception if file not exist
        catch (FileNotFoundException e){
            System.out.println("File doesn't exist");
        } // Close catch
    } // CLose Main

} // CLose class