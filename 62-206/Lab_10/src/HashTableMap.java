import java.util.ArrayList;
import java.util.Random;

public class HashTableMap<K,V> {
	
	protected static class HashEntry<K,V> implements Entry<K,V> {
		protected K key;
		protected V value;
		public HashEntry(K k, V v) { key = k; value = v; }
		public V getValue() { return value; }
		public K getKey() { return key; }
		public V setValue(V val) {
			V oldValue = value;
			value = val;
			return oldValue;
		}
		public boolean equals(Entry<K,V> o) {
			HashEntry<K,V> ent;
			try { ent = (HashEntry<K,V>) o; }
			catch (ClassCastException ex) { return false; }
			return (ent.getKey().equals(key)) && (ent.getValue().equals(value));
		}
		
		public String toString() { return "[" + key + "," + value + "]"; }
	}
	protected Entry<K,V> AVAILABLE = new HashEntry<K,V>(null, null); // marker
	protected int n = 0;                       // number of entries in the table
	protected int capacity; // capacity of the bucket array
	protected Entry<K,V>[] bucket;// bucket array
	protected int scale, shift;   // the shift and scaling factors
	/** Creates a hash table with initial capacity 1023. */
	public HashTableMap() { this(1023); }
	/** Creates a hash table with the given capacity. */
	public HashTableMap(int cap) {
		capacity = cap;
		bucket = (Entry<K,V>[]) new Entry[capacity]; // safe cast
		Random rand = new Random();
		scale = rand.nextInt(capacity-1) + 1;
		shift = rand.nextInt(capacity - 1) + 1;
		
	}
	/** Determines whether a key is valid. */
	protected void checkKey(K k) {
		if (k == null) throw new InvalidKeyException("Invalid key: null.");
	}
	/** Hash function applying MAD method to default hash code. */
	public int hashValue(K key) {
		return Math.abs(key.hashCode()*scale + shift) % capacity;
	}
	/** Returns the number of entries in the hash table. */
	public int size() { return n; }
	/** Returns whether or not the table is empty. */
	public boolean isEmpty() { return (n == 0); }
	/** Returns an iterable object containing all of the keys. */
	public Iterable<K> keys() {
		ArrayList<K> keys = new ArrayList<K>();
		for (int i=0; i<capacity; i++)
			if ((bucket[i] != null) && (bucket[i] != AVAILABLE))
				keys.add(bucket[i].getKey());
		return keys;
	}
	
	public Iterable<Entry<K,V>> entries() {
		ArrayList<Entry<K,V>> ent = new ArrayList<Entry<K,V>>();
		for (int i=0; i<capacity; i++)
			if ((bucket[i] != null) && (bucket[i] != AVAILABLE))
				ent.add(bucket[i]);
		return ent;
	}
	/** Helper search method - returns index of found key or -(a + 1),
	 * where a is the index of the first empty or available slot found. */
	protected int findEntry(K key) throws InvalidKeyException {
		// your work is here.
		int avail = -1;
		checkKey(key);
		int i = hashValue(key);
		int j = i;
		do {
			Entry<K,V> e = bucket[i];
			if ( e == null) {
				if (avail < 0)
					avail = i;
				break;
			}
			if (key.equals(e.getKey()))
				return i;
			if (e == AVAILABLE) {
				if (avail < 0)
					avail = i;
			}
			i = (i + 1) % capacity;
		} while (i != j);
		return -(avail + 1);
	}
	/** Returns the value associated with a key. */
	public V get (K key) throws InvalidKeyException {
		int i = findEntry(key);  // helper method for finding a key
		if (i < 0) return null;  // there is no value for this key
		return bucket[i].getValue();     // return the found value in this case
	}
	/** Put a key-value pair in the map, replacing previous one if it exists. */
	public V put (K key, V value) throws InvalidKeyException {
		int i = findEntry(key); //find the appropriate spot for this entry
		if (i >= 0)          //  this key has a previous value
			return ((HashEntry<K,V>) bucket[i]).setValue(value); // set new value
		if (n >= capacity/2) {
			rehash(); // rehash to keep the load factor <= 0.5
			i = findEntry(key); //find again the appropriate spot for this entry
		}
		bucket[-i-1] = new HashEntry<K,V>(key, value); // convert to proper index
		n++;
		return null;     // there was no previous value
	}
	/** Doubles the size of the hash table and rehashes all the entries. */
	protected void rehash() {
		// your work is here.
		capacity = 2*capacity;
		Entry<K,V>[] old = bucket;
		bucket = (Entry<K,V>[]) new Entry[capacity];
		java.util.Random rand = new java.util.Random();
		scale = rand.nextInt(capacity-1) + 1;
		shift = rand.nextInt(capacity);
		for(Entry<K, V> e: old){
			if((e!=null)&&(e!=AVAILABLE)) {
				int j=-1-findEntry(e.getKey());
				bucket[j]=e;
			}
		}
	}
	/** Removes the key-value pair with a specified key. */
	public V remove (K key) throws InvalidKeyException {
		int i = findEntry(key);                 // find this key first
		if (i < 0) return null;     // nothing to remove
		V toReturn = bucket[i].getValue();
		bucket[i] = AVAILABLE;                              // mark this slot as deactivated
		n--;
		return toReturn;
	}
	
	public static void main(String[] args) {
		
		HashTableMap<Integer, Integer> M = new HashTableMap<>(7);
		M.put(5,6);
		M.put(4, 7);
		
		System.out.print ("The keys are "  + M.keys());
		System.out.print("\n");
		
		System.out.print ("The values are "  + M.entries());
		System.out.print("\n");
		
		System.out.print ("The only value for 5 is "  + M.get(5));
		System.out.print("\n");
		for (int i = 7; i <= 100; ++i)
			M.put(i, i);
		M.remove (7);
		System.out.print ("The size of M is "  + M.size());
		System.out.print("\n");
		
		System.out.print ("The values are "  + M.entries());
		System.out.print("\n");
		
		int count = 0;
		for (Entry<Integer, Integer> s: M.entries()) {
			System.out.print(s);
			count++;
			if (count % 15 == 0)
				System.out.println();
		}
		System.out.println();
		HashTableMap<Integer, String> M1 = new HashTableMap<Integer, String>(7);
		String s1 = "Hello";
		String s2 = new String (s1);
		M1.put (32, s1);
		M1.put (31, s2);
		
		System.out.print ("The values are "  + M1.entries());
		System.out.print("\n");
		
	}
}