package CH7;//Code Listing 7-26 pg#516

import java.util.ArrayList;

public class ArrayListDemo4 {

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

		// Now insert an item at index 1.
		nameList.add(1,"Mary");

		System.out.println("Mary was added at index 1. Here are the items now." );

		//Display the items in nameList an their indices
		for (int index =0; index<nameList.size(); index++){
			System.out.println("Index: " + index + " Name: " + nameList.get(index));
		}
	}
}
