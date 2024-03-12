package Assignment_3;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookEntryTest {

	public static void main(String[] args) {
		ArrayList<PhoneBookEntry> phonebook = new ArrayList<>();  // Array
		Scanner Keyboard = new Scanner(System.in);  // Scanner
		System.out.println("\nEnter 5 phone book details" + "\n e.g. Asit 2047307788");

		//input for loop
		for(int index=0; index<5; index++){
			String str = Keyboard.nextLine();
			PhoneBookEntry rec = new PhoneBookEntry(str.split(" ")[0],Long.parseLong(str.split(" ")[1]));
			phonebook.add(rec);
		}

		// output for loop
		System.out.println("Records are: ");
		for (PhoneBookEntry data : phonebook) {
			System.out.println("Name: " + data.getName() + " Phone No: " + data.getNumber());
		}
	}
}