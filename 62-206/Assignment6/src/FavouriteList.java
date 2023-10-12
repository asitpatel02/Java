//import java.util.Random;

public class FavouriteList<E> {
	protected NodePositionList<Entry<E>> favouriteList;

	public FavouriteList() {
		favouriteList = new NodePositionList<Entry<E>>(){};
	}

	public int size() {
		return favouriteList.size();
	}

	public boolean isEmpty() {
		return favouriteList.isEmpty();
	}

	public void remove(E e) {
		Position<Entry<E>> p = find(e);
		if (p != null)
		{
			favouriteList.remove(p);
		}

	}

	public void access(E e) {
		if (favouriteList.isEmpty())
		{
			favouriteList.addFirst(new Entry<E>(e));
		}
		else
		{
			Position<Entry<E>> p = find(e);
			if (p != null) {
				p.element().incrementCount();
				moveUp(p);
			}
			else
			{
				favouriteList.addLast(new Entry<E>(e));
				p = favouriteList.last();
			}
		}
	}

	protected void moveUp(Position<Entry<E>> cur) {
		Entry<E> e = cur.element();
		int c = count(cur);
		while (cur != favouriteList.first()) {
			Position<Entry<E>> prev = favouriteList.prev(cur);
			if (c <= count(prev)) {
				break;
			}
			favouriteList.set(cur, prev.element());
			cur = prev;
		}
		favouriteList.set(cur, e);
	}

	protected Position<Entry<E>> find(E e) throws EmptyListException
	{
		if (isEmpty())
		{
			throw new EmptyListException("Empty list.");
		}
		Position<Entry<E>> p = favouriteList.first();
		while (true)
		{
			if (value(p).equals(e))
			{
				return p;
			}
			if (p == favouriteList.last() || p == null) {
				break;
			}
			p = favouriteList.next(p);
		}
		return null;
	}

	public PositionList<E> top(int k)
	{
		if (k < 0 || k > favouriteList.size())
		{
			throw new IllegalArgumentException("Illegal argument.");
		}
		NodePositionList<E> T = new NodePositionList<E>();
		int i = 0;
		Position<Entry<E>> p = favouriteList.first();
		while (i++ < k) {
			T.addLast(value(p));
			p = favouriteList.next(p);
		}
		return T;
	}

	protected E value(Position<Entry<E>> p) {
		return (p.element()).value;
	}

	protected int count(Position<Entry<E>> p) {
		return (p.element()).count;
	}
	public String toString()
	{
		return favouriteList.toString();
	}

	/**
	 * public static void main(String[] args)
	 * {
	 * FavouriteList<Integer> FL = new FavouriteList<Integer>();
	 * int numOfAccess = 2000;
	 * int intRange = 100;
	 * Random rand = new Random();
	 * for(int i=0; i<numOfAccess; i++)
	 * {
	 * FL.access(new Integer (rand.nextInt(intRange + 1)));
	 * }
	 * System.out.println(FL.top(intRange));
	 *
	 * for(int i=0; i<intRange + 1; i++)
	 * {
	 * System.out.println(i + " was accessed " + FL.count(FL.find(new Integer(i))) +
	 * " times.");
	 * }
	 *
	 * }
	 **/

	static class Entry<E>
	{
		protected int count;
		protected E value;

		Entry(E e)
		{
			count = 0;
			value = e;
		}

		void incrementCount() {
			count++;
		}
		public String toString()
		{
			return(value.toString());
		}
	}

}