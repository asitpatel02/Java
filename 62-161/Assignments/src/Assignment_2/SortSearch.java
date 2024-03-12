package Assignment_2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SortSearch {

	public static void main(String[] args) throws IOException {

		String UserName;
		int location;

		Scanner keyboard = new Scanner(System.in);

		final int NUMBER_OF_NAMES=400;
		String[] names = new String[NUMBER_OF_NAMES];

		fileToArrayReader(names,"PopularNames.txt");
		sortSelection(names);

		do {
			System.out.print("Enter the name you want ot found or enter quit to Exit: ");
			UserName = keyboard.nextLine();

			if (!UserName.equalsIgnoreCase("quit")){        //entering quit to exit Program
				location = binarySearch(names,UserName);

				if (location != -1){
					System.out.println("The name " + UserName + " is present in the list popular name and the location of your name is " + (location+1));
				} else {
					System.out.println("The name " + UserName + " is not present in the list of popular names.");
				}
			}
		} while (!UserName.equalsIgnoreCase("quit"));  // ignoreCase to for Quit or quit
	}

	// open the file and read and check the names...
	public static void fileToArrayReader(String[] array, String fileName) throws IOException{

		int i=0;
		File file = new File(fileName);
		Scanner readFile = new Scanner(file);

		while (readFile.hasNext() && i < array.length){
			array[i] = readFile.nextLine();
			i++;
		}
		readFile.close();
	}

	// Search the name in the in text files
	public static void sortSelection(String[] array){

		int startScan, minIndex, index;
		String minValue;

		for (startScan=0; startScan<array.length;startScan++){
			minIndex = startScan;
			minValue = array[startScan];

			for (index=startScan+1;index<array.length;index++){
				if (array[index].compareToIgnoreCase(minValue)<0){
					minValue = array[index];
					minIndex = index;
				}
			}
			array[minIndex] = array[startScan];
			array[startScan] = minValue;
		}
	}

	// Search the user enter name and also line number all names filtered by a to z
	public static int binarySearch(String[] array, String name){

		int first,middle,last,location;
		boolean found = false;
		location = -1;
		first = 0;
		last = array.length-1;

		while(!found && first <= last){
			middle = (first + last)/2;

			if (name.compareToIgnoreCase(array[middle])==0){
				location = middle;
				found = true;
			} else if (name.compareToIgnoreCase(array[middle])<0){
				last = middle-1;
			} else {
				first = middle +1;
			}
		}
		return location;
	}
}