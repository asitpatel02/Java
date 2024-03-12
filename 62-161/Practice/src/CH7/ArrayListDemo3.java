package CH7;//Code Listing 7-25 pg#515

import java.util.ArrayList;

public class ArrayListDemo3 {

	public static void main(String[] args) {

		//Create ArrayList to hold some names
		ArrayList<String> nameList = new ArrayList<>();

		// add some names to the arraylist
		nameList.add("James");
		nameList.add("Catherine");
		nameList.add("Bill");

		//Display the items in nameList an their indices
		for (int index =0; index<nameList.size(); index++){
			System.out.println("Index: " + index + " Name: " + nameList.get(index));
		}

		//Now remove the item at index 1
		nameList.remove(1);

		System.out.println("The item at index 1 is removed. Here are the items now." );

		//Display the items in nameList an their indices
		for (int index =0; index<nameList.size(); index++){
			System.out.println("Index: " + index + " Name: "+ nameList.get(index));
		}
	}
}
