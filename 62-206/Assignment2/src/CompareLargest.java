public class CompareLargest
{
	public static Comparable find_Largest(Comparable[] arr)
	{
		//declare and initialize a variable to store the largest value
		Comparable largest=arr[0];
		
		//search over the array and find the largest
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i].compareTo(largest)>0)
			{
				largest=arr[i];
			}
		}
		// return largest
		return largest;
	}
	public static void main(String[] args)
	{
		Double[] d= {1.3,2.5,3.7,5.0,11.7,19.8,15.6,17.4};
		System.out.println("Largest Double: "+find_Largest(d));
		
		Integer[] i= {5,6,7,8,4,3,2,1,9,8};
		System.out.println("Largest Integer: "+find_Largest(i));
		
		String[] s = {"Hunter", "Luke", "Nathan", "Kevin", "Daniel", "Eric"};
		System.out.println("Largest string: " + find_Largest(s));
	}
}