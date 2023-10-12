import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RodCutting {
    public static void main(String[] args) throws IOException {
        // Ensure that the program is called with two arguments: input file and output file
        if (args.length != 2) {
            System.out.println("Usage: java RodCutting <input_file> <output_file>");
            return;
        }

        // Extract the input and output file names from the command-line arguments
        String inputFile = args[0];
        String outputFile = args[1];

        // Open the input and output files for reading and writing, respectively
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        // Read the number of instances from the input file
        int n = Integer.parseInt(reader.readLine());

        // Process each instance of the problem
        for (int i = 0; i < n; i++) {
            // Read the length of the price list for the current instance
            int m = Integer.parseInt(reader.readLine());
            // Initialize an array to hold the prices for each length
            int[] prices = new int[m];

            // Read the prices for each length and store them in the prices array
            for (int j = 0; j < m; j++) {
                prices[j] = Integer.parseInt(reader.readLine());
            }

            // Calculate the maximum revenue that can be obtained for the current instance
            int result = getMaxRevenue(prices);
            // Write the result to the output file
            writer.write(String.valueOf(result));
            writer.newLine();
        }

        // Close the input and output files
        reader.close();
        writer.close();
    }

    //This function computes the maximum possible revenue that can be obtained
    //by cutting a rod of length as per the prices specified.
    private static int getMaxRevenue(int[] prices) {
        // Get the length of the price list
        int n = prices.length;
        // Initialize an array to hold the maximum revenue for each rod length
        int[] dp = new int[n + 1];
    
        /* Loop through the prices using dynamic programming approach, 
        calculating the maximum profit for each length */
        for (int i = 1; i <= n; i++) {
            int max = -1;
    
            // Compute the maximum revenue when the rod is cut at various points
            for (int j = 0; j < i; j++) {
                max = Math.max(max, prices[j] + dp[i - j - 1]);
            }
    
            /* Store the result: maximum revenue achievable,
             for the current rod length in the dp array */
            dp[i] = max;
        }
    
       //Return the computed maximum revenue for rod of length n
        return dp[n];
    }
}