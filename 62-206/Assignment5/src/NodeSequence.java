/**
 * An implementation of a sequence, using a linked position list
 * as its underlying data structure.
 */

public class NodeSequence<E> extends NodePositionList<E> implements Sequence<E> {

  /**
   * Default Constructor
   */
   public NodeSequence() {
      super();
   }

   protected void checkIndex(int i)
          throws IndexOutOfBoundsException {
      if (i < 0 || i >= numElts)
         throw new IndexOutOfBoundsException("Index " + i + " is out of bounds!");
   }

// from interface Sequence

  /**
   * Returns the position containing the element at the given index.
   */
   public Position<E> atIndex(int index)
          throws BoundaryViolationException {
      DNode<E> node;
      checkIndex(index);

	  if (index <= numElts/2) {
	     node = header.getNext();
         for (int i=0; i<index; ++i)
            node = node.getNext();
      } else {
         node = trailer.getPrev();
         for (int i=1; i<(numElts-index); ++i)
            node = node.getPrev();
      }

      return node;
   }

  /**
   * Returns the index of the element stored at the given position.
   */
   public int indexOf(Position<E> p)
          throws InvalidPositionException {
      checkPosition(p);

      int index=0;

      DNode<E> node = header.getNext();
      while (node != trailer) {
	     ++index;
	     if (node == p)
	        return index;
	     else
	        node = node.getNext();
	  }

      throw new InvalidPositionException("Position was not present in list!");

   }



// from interface Deque

  /**
   * Returns the first element; an exception is thrown if sequence is empty.
   */
   public E getFirst()
          throws EmptyDequeException {
      return first().element();
   }

  /**
   * Returns the last element; an exception is thrown if sequence is empty.
   */
   public E getLast()
          throws EmptyDequeException {
      return last().element();
   }

  /**
   * Removes the first element; an exception is thrown if sequence is empty.
   */
   public E removeFirst()
          throws EmptyDequeException {
      return remove(first());
   }

  /**
   * Removes the last element; an exception is thrown if sequence is empty.
   */
   public E removeLast()
          throws EmptyDequeException {
      return remove(last());
   }



// from interface IndexList

  /**
   * Inserts an element e to be at index i, shifting all elements after this.
   */
   public void add(int i, E e)
          throws IndexOutOfBoundsException {
      checkIndex(i);

      if (i == numElts) {
         addLast(e);
      } else {
		 addBefore(atIndex(i), e);
	  }
   }

  /**
   * Returns the element at index i, without removing it.
   */
   public E get(int i)
          throws IndexOutOfBoundsException {
      checkIndex(i);

      return atIndex(i).element();
   }

  /**
   * Removes and returns the element at index i, shifting the elements after this.
   */
   public E remove(int i)
          throws IndexOutOfBoundsException {
      checkIndex(i);

      return remove(atIndex(i));
   }

  /**
   * Replaces the element at index i with e, returning the previous element at i.
   */
   public E set(int i, E e)
          throws IndexOutOfBoundsException {
      checkIndex(i);

      return set(atIndex(i), e);
   }



// from interface iterable

   public java.util.Iterator<E> iterator() {
      return new ElementIterator<E>(this);
   }



// other fuctions

   public String toString() {
      return toString(this);
   }

 }