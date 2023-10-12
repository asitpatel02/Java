import java.util.Iterator;

public class NodePositionList<E> implements PositionList<E>
{
	protected int numElts;
	protected DNode<E> header, trailer;

	public NodePositionList()
	{
		numElts = 0;
		header = new DNode<E>(null, null, null);
		trailer = new DNode<E>(header, null, null);
		header.setNext(trailer);
	}

	protected DNode<E> checkPosition(Position<E> p) throws InvalidPositionException
	{
		if(p==null){throw new InvalidPositionException("Null position.");}
		if(p==header){throw new InvalidPositionException("Null position.");}
		if(p==trailer){throw new InvalidPositionException("Null position.");}
		try
		{
			DNode<E> temp =(DNode<E>) p;
			if((temp.getPrev()==null)||(temp.getNext()==null))
			{
				throw new InvalidPositionException("Null position.");
			}
			return temp;
		}
		catch(ClassCastException e){throw new InvalidPositionException("Null position.");}
	}
	public int size(){return numElts;}
	public boolean isEmpty(){return numElts==0;}

	public Position<E> first() throws InvalidPositionException
	{
		if(isEmpty()){throw new InvalidPositionException("Null position.");}
		return header.getNext();
	}
	public Position<E> last() throws InvalidPositionException
	{
		if(isEmpty()){throw new InvalidPositionException("Null position.");}
		return trailer.getPrev();
	}
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException
	{
		DNode<E> v = checkPosition(p);
		DNode<E> prev = v.getPrev();
		if(prev == header){throw new BoundaryViolationException("The header is not a valid position.");}
		return prev;
	}
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException
	{
		DNode<E> v = checkPosition(p);
		DNode<E> next = v.getNext();
		if(next == trailer){throw new BoundaryViolationException("The trailer is not a valid position.");}
		return next;
	}

	public void addBefore(Position<E> p, E elem) throws InvalidPositionException
	{
		DNode<E> v = checkPosition(p);
		DNode<E> newNode = new DNode<E>(v.getPrev(), v, elem);
		v.getPrev().setNext(newNode);
		v.setPrev(newNode);
		numElts++;
	}
	public void addAfter(Position<E> p, E elem) throws InvalidPositionException
	{
		DNode<E> v = checkPosition(p);
		DNode<E> newNode = new DNode<E>(v, v.getNext(), elem);
		v.getNext().setPrev(newNode);
		v.setNext(newNode);
		numElts++;
	}

	public void addFirst(E elem)
	{
		DNode<E> newNode = new DNode<E>(header, header.getNext(), elem);
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
		numElts++;
	}
	public void addLast(E elem)
	{
		DNode<E> newNode = new DNode<E>(trailer.getPrev(), trailer, elem);
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
		numElts++;
	}

	public E remove(Position<E> p) throws InvalidPositionException
	{
		DNode<E> v = checkPosition(p);
		E vElem = p.element();
		DNode<E> vPrev = v.getPrev();
		DNode<E> vNext = v.getNext();
		vPrev.setNext(vNext);
		vNext.setPrev(vPrev);
		v.setNext(null);
		v.setPrev(null);
		numElts--;
		return vElem;
	}

	public E set(Position<E> p, E elem) throws InvalidPositionException
	{
		DNode<E> v = checkPosition(p);
		E oldElt = v.element();
		v.setElement(elem);
		return oldElt;
	}

	public iterable<E> iter(){return new ElementIterator<E>(this);}
	public PositionList<Position<E>> positions()
	{
		NodePositionList<Position<E>> P = new NodePositionList<Position<E>>();
		if(!isEmpty())
		{
			Position<E> p = first();
			while(true)
			{
				P.addLast(p);
				if(p == last()){break;}
				p = next(p);
			}
		}
		return P;
	}
	public static <E> String toString(PositionList<E> l)
	{
		iterable<E> it = l.iter();
		String s = "[";
		while(it.hasNext())
		{
			s += it.next();
			if(it.hasNext()){s += ", ";}
		}
		s += "]";
		return s;
	}

	public String toString(){return toString(this);}

	public static void main(String[] args)
	{
		NodePositionList<Integer> PL = new NodePositionList<Integer>();

		for(int i=0; i<10; i++)
		{
			PL.addLast(i+1);
		}
		for(int i=0; i<10; i++)
		{
			System.out.println(PL.remove(PL.last()));
			//System.out.println(PL.removeLast());
		}
	}

}