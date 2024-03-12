package Assignment_5;

public class MonthDemo {

	public static void main(String[] args) throws Exception  {
		Month m = null;
		try
		{
			m = new Month("September");
			System.out.println("Month " + m.getMonthNumber() + " is " + m.getMonthName());
			m = new Month("Septenber");
			System.out.println("Month " + m.getMonthNumber() + " is " + m.getMonthName());
		}
		catch(InvalidMonthNameException e)
		{
			System.out.println("Error - " + e.getMessage() + "\n");
		}
		for (int i = 0; i <= 13; i++)
		{
			try
			{
				assert m != null;
				m.setMonthNumber(i);
				System.out.println("Month " + m.getMonthNumber() +
						" is " + m.getMonthName());
			}
			catch (InvalidMonthNumberException e)
			{
				System.out.println("Error - " + e.getMessage());
			}
		}  //end for loop

	}
}
