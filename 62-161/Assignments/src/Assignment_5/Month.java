package Assignment_5;

public class Month {

	private int monthNumber;

	public Month(String m) throws InvalidMonthNameException, InvalidMonthNumberException {
		String upper = m.toUpperCase();
		switch (upper) {
			case "JANUARY" -> setMonthNumber(1);
			case "FEBRUARY" -> setMonthNumber(2);
			case "MARCH" -> setMonthNumber(3);
			case "APRIL" -> setMonthNumber(4);
			case "MAY" -> setMonthNumber(5);
			case "JUNE" -> setMonthNumber(6);
			case "JULY" -> setMonthNumber(7);
			case "AUGUST" -> setMonthNumber(8);
			case "SEPTEMBER" -> setMonthNumber(9);
			case "OCTOBER" -> setMonthNumber(10);
			case "NOVEMBER" -> setMonthNumber(11);
			case "DECEMBER" -> setMonthNumber(12);
			default -> throw new InvalidMonthNameException();
		}
	}

	public void setMonthNumber(int number) throws InvalidMonthNumberException {

		// valid input 1-12 otherwise default 1
		if ((number < 1) || (number > 12))
			throw new InvalidMonthNumberException(number);
		else
			monthNumber = number;
	}

	public int getMonthNumber(){
		return monthNumber;
	}

	public String getMonthName() throws InvalidMonthNumberException {
		return switch (monthNumber) {
			case 1 -> "JANUARY";
			case 2 -> "FEBRUARY";
			case 3 -> "MARCH";
			case 4 -> "APRIL";
			case 5 -> "MAY";
			case 6 -> "JUNE";
			case 7 -> "JULY";
			case 8 -> "AUGUST";
			case 9 -> "SEPTEMBER";
			case 10 -> "OCTOBER";
			case 11 -> "NOVEMBER";
			case 12 -> "DECEMBER";
			default -> throw new InvalidMonthNumberException(monthNumber);
		};
	}

}
