import java.util.Comparator;
public class BinaryTest<E> implements Comparator<E>
{
	public int countBits2(E a)
	{
		if(a == null)
			throw new RuntimeException("Null bits.");

		try
		{
			int numOnes = 0;
			String str = Integer.toBinaryString((Integer) a);
			for(int i = 0; i < str.length(); i++)
			{
				if(str.charAt(i) == '1')
					numOnes++;
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
		int valA = countBits2(a);
		int valB = countBits2(b);
		return(valA - valB);
	}
}