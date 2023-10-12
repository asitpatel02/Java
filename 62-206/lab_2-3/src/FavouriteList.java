

import java.util.Random;


public class FavouriteList<E>
{
	protected NodePositionList<Entry<E>> fList;

	public FavouriteList()
	{
		fList = new NodePositionList<>();
	}

	public boolean isEmpty(){return fList.isEmpty();}

	public void access(E e)
	{
		if(fList.isEmpty())
		{
			fList.addFirst(new Entry<>(e));
		}
		else
		{
			Position<Entry<E>> p = find(e);
			if(p!=null)
			{
				p.element().incrementCount();
			}
			else
			{
				fList.addLast(new Entry<>(e));
				p = fList.last();
			}
			moveUp(p);
		}
	}

	protected void moveUp(Position<Entry<E>> cur)
	{
		Entry<E> e = cur.element();
		int c = count(cur);
		while(cur != fList.first())
		{
			Position<Entry<E>> prev = fList.prev(cur);
			if(c<=count(prev)){break;}
			fList.set(cur, prev.element());
			cur = prev;
		}
		fList.set(cur, e);
	}

	protected Position<Entry<E>> find(E e) throws EmptyListException
	{
		if(isEmpty()){throw new EmptyListException("Empty list.");}
		Position<Entry<E>> p = fList.first();
		while(true)
		{
			if(value(p).equals(e)){return p;}
			if(p == fList.last()){break;}
			p = fList.next(p);
		}
		if(p == fList.last()){return null;}
		else{return p;}

	}

	public PositionList<E> top(int k)
	{
		if(k<0 || k>fList.size()){throw new IllegalArgumentException("Illegal argument.");}
		if(k> fList.size())
		{
			System.out.println("There are only " + fList.size() + " entries in the list. Showing all entries...");
			k = fList.size() - 1;
		}

		NodePositionList<E> T = new NodePositionList<>();
		int i = 0;
		Position<Entry<E>> p = fList.first();
		while(i++<k)
		{
			T.addLast(value(p));
			p = fList.next(p);
		}


		return T;
	}

	protected E value(Position<Entry<E>> p)
	{
		return (p.element()).value;
	}
	protected int count(Position<Entry<E>> p)
	{
		return (p.element()).count;
	}

	public String toString()
	{
		return fList.toString();
	}

	public static void main(String[] args)
	{
		FavouriteList<Integer> FL = new FavouriteList<>();
		int numOfEntry = 10;
		Random rand = new Random();
		int x;
		for(int i=0; i<numOfEntry; i++)
		{
			x= rand.nextInt(11);

			FL.access(x);
					System.out.print(x+" ");

		}

		System.out.println("\nAnswers:- " +FL.top(5));

	}


	static class Entry<E>
	{
		protected int count;
		protected E value;

		Entry(E e)
		{
			count = 0;
			value = e;
		}
		void incrementCount()
		{
			count++;
		}

	}

}