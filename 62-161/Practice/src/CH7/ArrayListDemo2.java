package CH7;// Code Listing 7-24 pg#514

import java.util.ArrayList;

public class ArrayListDemo2 {

	public static void main(String[] args) {

		//Create ArrayList to hold some names
		ArrayList<String> nameList = new ArrayList<>();

		// add some names to the arraylist
		nameList.add("James");
		nameList.add("Catherine");
		nameList.add("Bill");

		//Display the size of the arraylist
		System.out.println("The ArrayList has " + nameList.size() + " object stored in it.");

		//Now display the items in nameList
		for (String s : nameList) System.out.println(s);
	}
}
