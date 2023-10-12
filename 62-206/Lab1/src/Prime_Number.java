import java.util.Scanner;

public class Prime_Number
{
	public static void main(String[] args)
	{
		int i, number, count, limit;
		
		System.out.print ("Enter the limit: ");
		Scanner scanner = new Scanner (System.in);
		limit = scanner.nextInt ();
		
		System.out.println(" Prime Numbers between 1 to " + limit + " are : ");
		for(number = 1; number <= limit; number++)
		{
			count = 0;
			for (i = 2; i <= number/2; i++)
			{
				if(number % i == 0)
				{
					count++;
					break;
				}
			}
			if(count == 0 && number != 1 )
			{
				System.out.print(number + " ");
			}
		}
	}
	
}
