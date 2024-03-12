package CH7;// code Listing 7-23 pg#513

import java.util.ArrayList;

public class ArrayListDemo1 {

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
		for(int index = 0; index < nameList.size(); index++)
			System.out.println(nameList.get(index));
	}
}