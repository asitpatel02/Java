package CH9;

import java.util.StringTokenizer;

public class DateComponent {

	private final String month;   // To hold the month
	private final String day;     // To hold the day
	private final String year;    // To hold the year

	/**
	 The constructor accepts a String containing a date
	 in the form MONTH/DAY/YEAR. It extracts the month,
	 day, and year from the string.
	 @param dateStr A String containing a date.
	 */

	public DateComponent(String dateStr)
	{
		// Create a StringTokenizer object.
		StringTokenizer strTokenizer =
				new StringTokenizer(dateStr, "/");

		// Extract the tokens.
		month = strTokenizer.nextToken();
		day = strTokenizer.nextToken();
		year = strTokenizer.nextToken();
	}

	/**
	 getMonth method
	 @return The month field.
	 */

	public String getMonth()
	{
		return month;
	}

	/**
	 getDay method
	 @return The day field.
	 */

	public String getDay()
	{
		return day;
	}

	/**
	 getYear method
	 @return The year field.
	 */

	public String getYear()
	{
		return year;
	}
}
