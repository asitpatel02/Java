import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList; 
import java.util.Comparator;
import java.util.Scanner;

public class ActivityScheduling {
    public static void main(String[] args) throws FileNotFoundException { //main method that throws exception if file not found
        if (args.length != 2) { //checks for two arguments passed through command line
            System.err.println("Usage: java ActivityScheduling <input_file> <output_file>");
            System.exit(1); 
        }

        String inputFile = args[0]; //store first input as string
        String outputFile = args[1]; //store second input as string

        Scanner scanner = new Scanner(new File(inputFile)); //create scanner object of input file to read input data
        PrintWriter writer = new PrintWriter(new File(outputFile)); //printWriter is used to write output to a text file

        int numInstances = scanner.nextInt(); //reading integer value from input file
        for (int i = 0; i < numInstances; i++) { //loop over numInstances to find maximum activities that can be scheduled 
            int numActivities = scanner.nextInt(); //read number of activities available
            ArrayList<Activity> activities = new ArrayList<>(); //create arraylist of activity objects

            for (int j = 0; j < numActivities; j++) { //iterate over activities list and add activity objects to arraylist
                int startTime = scanner.nextInt(); //read start time of current activity
                int finishTime = scanner.nextInt(); //read finish time of current activity
                activities.add(new Activity(startTime, finishTime)); //adding activity object to activities arraylist with given start and finish times  
            }

            int maxActivities = getMaxActivities(activities); //get max possible activities for each instance of the problem
            writer.println(maxActivities); //write result for each instance of the problem in output file
        }

        scanner.close(); //close the scanner object as reading is finished
        writer.close(); //close printWriter object as writing is finished
    }

    private static int getMaxActivities(ArrayList<Activity> activities) { //method to get maximum possible activities for each instance of the problem
        activities.sort(Comparator.comparingInt(a -> a.finishTime)); //sort activities according to finish time, so it will be easier to find the earliest finish time of activities

        int maxActivities = 0; //initialize maximum activities as zero 
        int currentFinishTime = 0; //initialize current finish time as zero

        for (Activity activity : activities) { //use foreach loop to iterate over activities objects
            if (activity.startTime >= currentFinishTime) { //check if start time of current activity is greater than or equal to current finish time
                maxActivities++; //if condition is true, increment maximum activities by 1 involved in instance 
                currentFinishTime = activity.finishTime; //update current finish time to finish time of current activity
            }
        }

        return maxActivities; //return the maximum activities involved in this instance of problem
    }
}

class Activity { //custom class named Activity to store start and finish times of each activity
    int startTime; 
    int finishTime;

    public Activity(int startTime, int finishTime) { //constructor of class activity taking start and finish times as input arguments
        this.startTime = startTime; //assigning input start time to object's startTime variable
        this.finishTime = finishTime; //assigning input finish time to object's finishTime variable
    }
}