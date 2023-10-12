public class ArrayIndexList<E> implements IndexList<E> {
    private E[] A;	      // array storing the elements of the indexed list
    private int capacity = 16;  // initial length of array A
    private int size = 0;	      // number of elements stored in the indexed list

    /** Creates the indexed list with initial capacity 16. */
    public ArrayIndexList() {
        A = (E[]) new Object[capacity]; // the compiler may warn, but this is ok
    }

    public int size() { return size;}

    public boolean isEmpty() { return size() == 0;}

    /** Inserts an element at the given index. */
    public void add(int r, E e) throws IndexOutOfBoundsException {
        // your work is here
        checkIndex(r, size() + 1);
        if (size()== capacity) {
            capacity *= 2;
            E[] B =(E[]) new Object[capacity];
            if (size >= 0) System.arraycopy (A, 0, B, 0, size);
            A = B;
        }
        if (size () - r >= 0) System.arraycopy (A, r, A, r + 1, size () - r);
        A[r] = e;
        size++;
    }

    public E get (int i)
            throws IndexOutOfBoundsException {
        checkIndex(i, size());
        return A[i];
    }

    /** Removes the element stored at the given index. */
    public E remove(int r)  throws IndexOutOfBoundsException {
        // Your work is here
        checkIndex(r, size());
        E temp = A[r];
        if (size - 1 - r >= 0) System.arraycopy (A, r + 1, A, r, size - 1 - r);
        size--;
        return temp;
    }

    public E set(int i, E e)
            throws IndexOutOfBoundsException {
        checkIndex(i, size());
        E temp = A[i];
        A[i] = e;
        return temp;
    }

    private void checkIndex(int r, int s) {
        if(r < 0 || r > s - 1) throw new IndexOutOfBoundsException
                ("Out of range of Index");
    }

    public static void main(String[] args) {
        // your work is here
        ArrayIndexList<Integer> S = new ArrayIndexList<> ();
        for (int i = 0; i <= 10; i++)
            S.add(i, i + 5);
        for (int i = 10; i > 0; i--)
            System.out.println (S.remove(i));
    }

}