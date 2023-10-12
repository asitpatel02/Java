import java.util.Comparator;
public class integerComparator<E> implements Comparator<E>
{
	private int countBits(E a)
	{
		if(a == null)
			throw new RuntimeException("Null bit count.");
		try
		{
			int numOnes = 0;
			int tmp = ((Integer) a).intValue();
			while(tmp != 0)
			{
				int bit = tmp & 1;
				if(bit == 1)
					numOnes++;
				tmp = tmp >> 1;
			}
			return numOnes;
		}

		catch(ClassCastException e)
		{
			throw new RuntimeException("Class cast exception.");
		}
	}

	public int compare(E a, E b)
	{
		int valA = countBits(a);
		int valB = countBits(b);
		return(valA - valB);
	}
}
