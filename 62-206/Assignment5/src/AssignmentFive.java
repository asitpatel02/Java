/**
  * A class that implements the bubble sort algorithm and the merge sort
  * algorithm for sorting sequences, and demonstrates their use on some
  * randomly generated NodeSequence's.
  */

import java.util.Comparator;

public class AssignmentFive {

   public static void main(String[] args) {
      Sequence<Integer> seq;
      java.util.Random r = new java.util.Random();
      Timer t = new Timer();

      for (int i=0; i<7; ++i) {
        seq = new NodeSequence<Integer>();
        for (int j=(int)Math.pow(4,i+1); j>0; --j) seq.addLast(new Integer(r.nextInt(5000)));
           t.start();
           bubbleSort(seq, new DefaultComparator<Integer>());
           System.out.println("BubbleSort:\t" + seq.size() + " elements in " + t.elapsed() + "ms.");
           //System.out.println(seq);
        seq = new NodeSequence<Integer>();
        for (int j=(int)Math.pow(4,i+1); j>0; --j) seq.addLast(new Integer(r.nextInt(5000)));
           t.start();
           mergeSort(seq, new DefaultComparator<Integer>());
           System.out.println("MergeSort:\t" + seq.size() + " elements in " + t.elapsed() + "ms.");
           //System.out.println(seq);

        System.out.println();
      }

   }

  /**
   * Sorts the elements of the sequence in increasing order
   * using the bubble sort algorithm.
   */
   public static<E> void bubbleSort(Sequence<E> sequence, Comparator<E> c) {
      int n = sequence.size() - 1;
      for (int i=0; i<n; ++i) {
         Position<E> prev = sequence.first();
         for(int j=0; j<n-i; ++j) {
            Position<E> next = sequence.next(prev);
            if (c.compare(prev.element(), next.element())> 0) {
               E temp = prev.element();
               ((DNode<E>)prev).setElement(next.element());
               ((DNode<E>)next).setElement(temp);
		    }
            prev = next;
         }
      }
   }

  /**
   * Sorts the elements of list in in nondecreasing order according
   * to comparator c, using the merge-sort algorithm.
   **/
   public static <E> void mergeSort (Sequence<E> in, Comparator<E> c) {
      int n = in.size();
      if (n < 2)
         return;  // the in list is already sorted in this case
      // divide
      Sequence<E> in1 = new NodeSequence<E>();
      Sequence<E> in2 = new NodeSequence<E>();
      int i = 0;
      while (i < n/2) {
         in1.addLast(in.removeFirst()); // move the first n/2 elements to in1
         i++;
      }
      while (!in.isEmpty())
         in2.addLast(in.removeFirst()); // move the rest to in2
      // recur
      mergeSort(in1,c);
      mergeSort(in2,c);
      //conquer
      merge(in1,in2,c,in);
   }

  /**
   * Merges two sorted lists, in1 and in2, into a sorted list in.
   **/
   public static <E> void merge(Sequence<E> in1, Sequence<E> in2,
                                Comparator<E> c, Sequence<E> in) {
      while (!in1.isEmpty() && !in2.isEmpty())
         if (c.compare(in1.first().element(), in2.first().element()) <= 0)
            in.addLast(in1.remove(in1.first()));
         else
            in.addLast(in2.remove(in2.first()));
      while(!in1.isEmpty()) // move the remaining elements of in1
         in.addLast(in1.remove(in1.first()));
      while(!in2.isEmpty()) // move the remaining elements of in2
         in.addLast(in2.remove(in2.first()));
  }

}

@SuppressWarnings("unchecked")
class DefaultComparator<E> implements Comparator<E> {
  /**
   *Compares two given elements
   */
   public int compare(E a, E b) throws ClassCastException {
      return ((Comparable<E>) a).compareTo(b);
   }
}