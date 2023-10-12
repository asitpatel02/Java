/* 3. The Birthday paradox says that the probability (chance) that two people in a room
will have the same birthday is more than half as long as n, the number of people in the room, is more than or equal to 23.
the property is not really a paradox, but many people find in it surprising.

Write a java program the generates 10 sets of 23 valid birthday(ignore leap years)

check how many times the birthday paradox occurs.

Name : Asit Patel
Student ID: 190309

*/
import java.util.Arrays;
import java.util.Random;


public class BirthdayParadox {
	public static int[] sameBirthday(int n)
	{
		Random random = new Random ();
		int minDay = 1;
		int maxDay = 28;
		int minMonth = 1;
		int maxMonth = 12;
		int[] set = new int[n];
		for (int i=0; i<n;i++)
		{
			set[i] += (minMonth + random.nextInt (maxMonth-minMonth));
			set[i] += (minMonth + random.nextInt (maxDay-minDay))*Math.pow (10,2);
		}
		return set;
	}
	public static boolean isParadox(int []arr) {
		Arrays.sort(arr);
		for (int i=0;i< arr.length-1;i++){
			if(arr[i]!=arr[i+1]){
			} else {
				return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		int count = 0, count1 = 0;
		for (int i = 0; i < 10; i++)                // generate 10 sets
		{
			if (isParadox (sameBirthday (23)))
			{
				System.out.printf ("Set %d: Birthday paradox did happened\n", i+1);
				count++;
			} else {
				System.out.printf ("Set %d: Birthday paradox did not happened\n", i+1);
				count1++;
			       }
		}
		System.out.println ();
		System.out.println ("Number of time the paradox did occurred: " + count);
		System.out.println ("Number of time the paradox did not occurred: " + count1);
	}
}
