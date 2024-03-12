package CH8;
//Code Listing 8-18 pg#573

public class EnumDemo {

	//Declare the day enumerated type
	enum Day{SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,SATURDAY}

	public static void main(String[] args) {

		//Declare a day variable and assign it a value
		Day workday = Day.WEDNESDAY;

		//The following statement display WEDNESDAY
		System.out.println(workday);

		//The following statement display the ordinal value for day.sunday which is 0
		System.out.println("The ordinal value for " + Day.SUNDAY + " is " + Day.SUNDAY.ordinal());

		//The following statement display the ordinal value for Day.SATURDAY  which is 6
		System.out.println("The ordinal value for " + Day.SATURDAY + " is " + Day.SATURDAY.ordinal());

		//The following statement compares two enum constanta
		if (Day.FRIDAY.compareTo(Day.FRIDAY) > 0){
			System.out.println(Day.FRIDAY + " is greater than " + Day.MONDAY);
		} else {
			System.out.println(Day.FRIDAY + " is NOT greater than " + Day.MONDAY);
		}
	}
}
