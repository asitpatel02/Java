package Assignment_3;

public class Max {

	int max (int ... index)
	{
		int maxim = 0;
		for (int i:index)   //for loop for the all number
		{
			if (i > maxim)  // check the max number
			{
				maxim = i;
			}
		}
		return maxim;   // return the max number

	}
		public static void main (String[]args)
		{
			Max Num = new Max ();
			int x;
			x = Num.max(4); //x=4
			System.out.println ("The maximum numbers is: " + x);
			x = Num.max(1, 6, 3);   // x = 6
			System.out.println ("The maximum numbers is: " + x);
			x = Num.max(5,1,5,7,9,2,20,15,13);  // x = 20
			System.out.println ("The maximum numbers is: " + x);
		}
	}