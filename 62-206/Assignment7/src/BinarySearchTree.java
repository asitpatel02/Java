
import java.util.Comparator;
import java.util.Random;
import java.util.Iterator;
import java.lang.Iterable;
import java.util.ArrayList;


public class BinarySearchTree<K,V>
  extends LinkedBinaryTree<Entry<K,V>> {

  protected Comparator<K> C;	// comparator
  protected Position<Entry<K,V>> actionPos;
  protected int numEntries = 0;	// number of entries
  /** Creates a BinarySearchTree with a default comparator. */
  public BinarySearchTree()  {
    C = new DefaultComparator<K>();
    addRoot(null);
  }
  public BinarySearchTree(Comparator<K> c)  {
    C = c;
    addRoot(null);
  }
  /** Nested class for location-aware binary search tree entries */
  protected static class BSTEntry<K,V> implements Entry<K,V> {
    protected K key;
    protected V value;
    protected Position<Entry<K,V>> pos;
    BSTEntry() { /* default constructor */ }
    BSTEntry(K k, V v, Position<Entry<K,V>> p) {
      key = k; value = v; pos = p;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
    public Position<Entry<K,V>> position() { return pos; }
  }
  /** Extracts the key of the entry at a given node of the tree. */
  protected K key(Position<Entry<K,V>> position)  {
    return position.element().getKey();
  }
  /** Extracts the value of the entry at a given node of the tree. */
  protected V value(Position<Entry<K,V>> position)  {
    return position.element().getValue();
  }
  /** Extracts the entry at a given node of the tree. */
  protected Entry<K,V> entry(Position<Entry<K,V>> position)  {
    return position.element();
  }
  /** Replaces an entry with a new entry (and reset the entry's location) */
  protected void replaceEntry(Position <Entry<K,V>> pos, Entry<K,V> ent) {
    ((BSTEntry<K,V>) ent).pos = pos;
    replace(pos, ent);
  }
/** Checks whether a given key is valid. */
protected void checkKey(K key) throws InvalidKeyException {
  if(key == null)  // just a simple test for now
    throw new InvalidKeyException("null key");
}
/** Checks whether a given entry is valid. */
protected void checkEntry(Entry<K,V> ent) throws InvalidEntryException {
  if(ent == null || !(ent instanceof BSTEntry))
    throw new InvalidEntryException("invalid entry");
}
/** Auxiliary method for inserting an entry at an external node */
protected Entry<K,V> insertAtExternal(Position<Entry<K,V>> v, Entry<K,V> e) {
  if(isExternal (v)) {
	  BTNode<Entry<K, V>> lv = new BTNode (null, (BTNode<Entry<K, V>>) v, null, null);
	  BTNode<Entry<K, V>> rv = new BTNode (null, (BTNode<Entry<K, V>>) v, null, null);

	  ((BTNode<Entry<K, V>>) v).setLeft (lv);
	  ((BTNode<Entry<K, V>>) v).setRight (rv);
	  lv.setParent((BTNode<Entry<K, V>>) v);
	  rv.setParent((BTNode<Entry<K, V>>)v);
  }
  replaceEntry(v, e);
  numEntries++;
  return e;
}

/** Auxiliary method used by find, insert. */
protected Position<Entry<K,V>> treeSearch(K key, Position<Entry<K,V>> pos) {
  if (isExternal(pos)) return pos; // key not found; return external node
  else {
    K curKey = key(pos);
    int comp = C.compare(key, curKey);
    if (comp < 0)
      return treeSearch(key, left(pos));	// search left subtree
    else if (comp > 0)
      return treeSearch(key, right(pos));	// search right subtree
    return pos;		// return internal node where key is found
  }
}
// Adds to L all entries in the subtree rooted at v having keys equal to k
protected void addAll(PositionList<Entry<K,V>> L,
		      Position<Entry<K,V>> v, K k) {
  if (isExternal(v)) return;
  Position<Entry<K,V>> pos = treeSearch(k, v);
  if (!isExternal(pos))  {  // we found an entry with key equal to k
    addAll(L, left(pos), k);
    L.addLast(pos.element()); 	// add entries in inorder
    addAll(L, right(pos), k);
  } // this recursive algorithm is simple, but it's not the fastest
}

  public int size() { return numEntries; }
  public boolean isEmpty() { return size() == 0; }
  public Entry<K,V> find(K key) throws InvalidKeyException {
    checkKey(key);		// may throw an InvalidKeyException
    Position<Entry<K,V>> curPos = treeSearch(key, root());
    //actionPos = curPos;		// node where the search ended
    if (isInternal(curPos)) return entry(curPos);
    return null;
  }

  public Iterable<Entry<K,V>> findAll(K key) throws InvalidKeyException {
    checkKey (key);		// may throw an InvalidKeyException
    PositionList<Entry<K,V>> L = new NodePositionList<Entry<K,V>>();
    addAll(L, root(), key);
    return  (Iterable) L;
  }
  public Entry<K,V> insert(K k, V x) throws InvalidKeyException {
    checkKey(k);	// may throw an InvalidKeyException
    Position<Entry<K,V>> insPos = treeSearch(k, root());
    while (!isExternal(insPos))  // iterative search for insertion position
      insPos = treeSearch(k, left(insPos));
    actionPos = insPos;	// node where the new entry is being inserted
    return insertAtExternal(insPos, new BSTEntry<K,V>(k, x, insPos));
  }

  public static void main(String[] args) {
	  BinarySearchTree<Integer,Integer> BST = new BinarySearchTree<Integer,Integer>();
	  Random rand = new Random();
	  int n = 100;

      System.out.println ("The unsorted random numbers are \n");
      int j = 0;
	  for (int i = 0; i < n; ++i) {
		int z = rand.nextInt(1000);
	    BST.insert(z, z);
	    System.out.print (z + " ");
	    ++j;
	    if (j % 10 == 0)
	       System.out.println();

	 }


      System.out.println();

	  System.out.println("The size is " + BST.size());

	  System.out.println();

	  System.out.println ("The sorted numbers are \n");

      int count = 0;
	  for (Position <Entry<Integer, Integer>> in: BST.positions()) {
              if (BST.isInternal(in)) {
	  	      System.out.print((in.element()).getKey() + " ");
	  	      ++count;
	  	      if(count % 10==0)
	  	        System.out.println();}
	  		}
	           System.out.println();
	           System.out.println();

  }

}