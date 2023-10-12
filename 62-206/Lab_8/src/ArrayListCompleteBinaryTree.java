import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
public class ArrayListCompleteBinaryTree<E> extends LinkedBinaryTree<E> implements CompleteBinaryTree<E>
{
	protected ArrayList<BTPos<E>> T; // indexed list of tree positions

	/** Nested class for a index list-based complete binary tree node. */
	protected static class BTPos<E> implements Position<E>
	{
		E element;
		int index;

		public BTPos(E elt, int i)
		{
			element = elt;
			index = i;
		}

		public E element(){return element;}
		public int index(){return index;}
		public E setElement(E elt)
		{
			E temp = element;
			element = elt;
			return temp;
		}
	}

	/** default constructor */
	public ArrayListCompleteBinaryTree()
	{
		T = new ArrayList<BTPos<E>>();
		T.add(0, null); // the location at rank 0 is deliberately empty
	}

	/** Returns the number of (internal and external) nodes. */
	public int size() { return T.size() - 1; }
	/** Returns whether the tree is empty. */
	public boolean isEmpty() { return (size() == 0); }

	/** Returns whether v is an internal node. */
	public boolean isInternal(Position<E> v) throws InvalidPositionException
	{
		CheckPosition(v);
		return hasLeft(v); // if v has a right child it will have a left child
	}

	/** Returns whether v is an external node. */
	public boolean isExternal(Position<E> v) throws InvalidPositionException
	{
		//CheckPosition(v);
		return !isInternal(v);
	}

	/** Returns whether v is the root node. */
	public boolean isRoot(Position<E> v) throws InvalidPositionException
	{
		BTPos<E> vv = CheckPosition(v);
		return vv.index() == 1;
	}

	/** Returns whether v has a left child. */
	public boolean hasLeft(Position<E> v) throws InvalidPositionException
	{
		BTPos<E> vv = CheckPosition(v);
		return 2*vv.index() <= size();
	}

	/** Returns whether v has a right child. */
	public boolean hasRight(Position<E> v) throws InvalidPositionException
	{
		BTPos<E> vv = CheckPosition(v);
		return 2*vv.index() + 1 <= size();
	}

	/** Returns the root of the tree. */
	public Position<E> root() throws EmptyTreeException
	{
		if(isEmpty())
			throw new EmptyTreeException("Empty tree.");
		return T.get(1);
	}

	/** Returns the left child of v. */
	public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException
	{
		if(!hasLeft(v))
			throw new BoundaryViolationException("No left child found.");
		BTPos<E> vv = CheckPosition(v);
		return T.get(2 * vv.index());
	}

	/** Returns the right child of v. */
	public Position<E> right(Position<E> v) throws InvalidPositionException
	{
		if (!hasRight(v)) throw new BoundaryViolationException("No right child");
		BTPos<E> vv = CheckPosition(v);
		return T.get(2*vv.index() + 1);
	}

	/** Returns the parent of v. */
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException
	{
		if (isRoot(v)) throw new BoundaryViolationException("No parent");
		BTPos<E> vv = CheckPosition(v);
		return T.get(vv.index()/2);
	}

	/** Replaces the element at v. */
	public E replace(Position<E> v, E o) throws InvalidPositionException
	{
		BTPos<E> vv = CheckPosition(v);
		return vv.setElement(o);
	}

	/** Adds an element just after the last node (in a level numbering). */
	public Position<E> add(E e)
	{
		int i = size() + 1;
		BTPos<E> p = new BTPos<E> (e, i);
		T.add(i, p);
		return p;
	}

	/** Removes and returns the element at the last node. */
	public E remove() throws EmptyTreeException
	{
		if(isEmpty()) throw new EmptyTreeException("Tree is empty");
		return T.remove(size()).element();
	}

	/** Determines whether the given position is a valid node. */
	protected BTPos<E> CheckPosition(Position<E> v) throws InvalidPositionException
	{
		if(v == null || !(v instanceof BTPos))
			throw new InvaildPositionException("The chosen position is not valid.");
		return ((BTPos<E>) v);
	}

	/** Returns an iterator of the elements stored at all nodes in the tree. */
	public Iterable<E> iterator()
	{
		ArrayList<E> list = new ArrayList<E>();
		Iterator<BTPos<E>> iter = T.iterator();
		iter.next(); // skip the first element
		while (iter.hasNext())
			list.add(iter.next().element());
		return list;
	}

	public static void main(String[] args)
	{
		ArrayListCompleteBinaryTree<Integer> A = new ArrayListCompleteBinaryTree<Integer>();
		Random rand = new Random();
		System.out.println("Randomly inserted elements are \n\n");
		for (int i = 0; i <= 10; i++)
		{
			int s = rand.nextInt(1000);
			A.add(s);
			System.out.print (s + " ");
		}

		System.out.println("\n\nThe last removed element is \n" + A.remove() );
		System.out.println();
		System.out.println();
		System.out.println("The rest of elements is \n");
		for (Integer in: A.iterator())
			System.out.print(in + " ");
		System.out.println("\n");
	}
}