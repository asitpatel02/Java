import java.util.Random;

public class FavouriteListMTF<E> extends FavouriteList<E> {

	public FavouriteListMTF(){}

	protected void moveUp(Position<Entry<E>> pos)
	{
		favouriteList.addFirst(favouriteList.remove(pos));
	}

	public PositionList<E> top(int k)
	{
		if (k < 0 || k > size())
		{
			throw new IllegalArgumentException("Illegal argument.");
		}

		NodePositionList<E> T = new NodePositionList<E>();

		if (!isEmpty())
		{
			NodePositionList<Entry<E>> C = new NodePositionList<Entry<E>>();
			Position<Entry<E>> p1 = favouriteList.first();
			int i = 0;

			/**while (i++ < favouriteList.size())
			{
				C.addLast(p1.element());
			}**/

			for(Entry<E> e : favouriteList)
			{
				C.addLast(e);
			}
			for (int j = 0; j < k; j++)
			{
				Position<Entry<E>> maxPos = null;
				int maxCount = -1;
				Position<Entry<E>> p = C.first();
				while (true)
				{
					int c = count(p);
					if (c > maxCount)
					{
						maxCount = c;
						maxPos = p;
					}
					if (p == C.last())
					{break;}
					p = C.next(p);
				}
				T.addLast(value(maxPos));
				C.remove(maxPos);
			}
		}
		return T;
	}
	/**public static void main(String[] args)
	{
		FavouriteListMTF<Integer> FL = new FavouriteListMTF<Integer>();
		int numOfAccess = 2000;
		int intRange = 100;
		Random rand = new Random();
		for(int i=0; i<numOfAccess; i++)
		{
			FL.access(new Integer (rand.nextInt(intRange + 1)));
		}
		System.out.println(FL.top(intRange));

		for(int i=0; i<intRange + 1; i++)
		{
			System.out.println(i + " was accessed " + FL.count(FL.find(new Integer(i))) + " times.");
		}
	}**/

}