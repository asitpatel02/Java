
public class ArrayStackLab<E> implements Stack<E>
{
  protected int capacity;
	protected E[] S;
  protected int top = -1;
	
	public ArrayStackLab(int cap)
  {
    capacity = cap;
    S =  (E[]) new Object[capacity];
  }

  public int size()
  {
    return (top + 1);
  }

  public boolean isEmpty()
  {
    return (top < 0);
  }

  public void push(E element) throws FullStackException
  {
	  if (size() == capacity)
	  {
		  System.out.println("Doubling stack size");
		  capacity*=2;
		  E[] B;
		  B = (E[]) new Object[capacity];
		  System.arraycopy (S, 0, B, 0, S.length);
		  S = B;
	  }
		  S[++top] = element;
  }
	
	public E pop() throws EmptyStackException
  {
    E element;
    if (isEmpty())
      throw new EmptyStackException("Stack is empty.");
    element = S[top];
    S[top--] = null;
    return element;
  }

  public String toString()
  {
    StringBuilder s;
    s = new StringBuilder ("[");
    if (size() > 0) s.append (S[0]);
    if (size() > 1)
    {
    	for (int i = 1; i <= size() -1; i++)
    	{
			s.append (", ").append (S[i]);
		}
	}
    return s + "]";
  }

  public static <E> void reverse(E[] a)
  {
	  Stack<E> A = new ArrayStackLab<> (4);
	  for (E e : a) {
		  A.push (e);
	  }
	  for(int j = 0; j < a.length; j++)
	  {
		  a[j] = A.pop();
	  }
  }
	
	
	public static void main(String[] args)
  {
	  Integer[] I = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
	  String[] S = {"A", "B", "C", "D", "E", "F", "G", "I", "J"};
	  for (Integer integer : I) {
		  System.out.print (integer + ",");
	  }
	  System.out.println();
	  for (String s : S) {
		  System.out.print (s + ",");
	  }
	  System.out.println();
	  reverse(I);
	  reverse(S);
	  for (Integer integer : I) {
		  System.out.print (integer + ",");
	  }
	  System.out.println();
	  for (String s : S) {
		  System.out.print (s + ",");
	  }
	  System.out.println();
  }
}
