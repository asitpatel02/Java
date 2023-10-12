import java.util.Comparator;

public class SortedListAdaptablePriorityQueue<K,V> extends SortedListPriorityQueue<K,V> implements AdaptablePriorityQueue<K,V>
{
	public SortedListAdaptablePriorityQueue()
	{
		super();
	}

	public SortedListAdaptablePriorityQueue(Comparator<K> comp)
	{
		super(comp);
	}

	public Entry<K,V> insert(K k, V v) throws InvalidKeyException
	{
		checkKey(k);
		LocationAwareEntry<K,V> entry = new LocationAwareEntry<K,V>(k,v);
		insertEntry(entry);
		entry.setLocation(actionPos);
		return entry;
	}

	protected static class LocationAwareEntry<K,V> extends MyEntry<K,V> implements Entry<K,V>
	{
		private Position<Entry<K,V>> loc;

		public LocationAwareEntry(K key, V value)
		{
			super(key, value);
		}

		public LocationAwareEntry(K key, V value, Position<Entry<K,V>> pos)
		{
			super(key, value);
			loc = pos;
		}

		protected Position<Entry<K,V>> location()
		{return loc;}

		protected Position<Entry<K,V>> setLocation(Position<Entry<K,V>> pos)
		{
			Position<Entry<K,V>> oldPosition = location();
			loc = pos;
			return oldPosition;
		}

		protected K setKey(K key)
		{
			K oldKey = getKey();
			k = key;
			return oldKey;
		}

		protected V setValue(V value)
		{
			V oldValue = getValue();
			v = value;
			return oldValue;
		}
	}

	public Entry<K,V> remove(Entry<K,V> entry)
	{
		checkEntry(entry);
		LocationAwareEntry<K,V> e = (LocationAwareEntry<K,V>) entry;
		Position<Entry<K,V>> p = e.location();
		entries.remove(p);
		e.setLocation(null);
		return e;
	}

	public K replaceKey(Entry<K,V> entry, K k)
	{
		checkKey(k);
		checkEntry(entry);
		LocationAwareEntry<K,V> e = (LocationAwareEntry<K,V>) remove(entry);
		K oldKey = e.setKey(k);
		insertEntry(e);
		e.setLocation(actionPos);
		return oldKey;
	}

	public V replaceValue(Entry<K,V> e, V value)
	{
		checkEntry(e);
		V oldValue = ((LocationAwareEntry<K,V>) e).setValue(value);
		return oldValue;
	}

	protected void checkEntry(Entry<K,V> entry) throws InvalidEntryException
	{
		if(entry == null || !(entry instanceof LocationAwareEntry))
			throw new InvalidEntryException("Invalid entry.");
	}

	public static void main(String[] args)
	{
		int n = 20;

		SortedListAdaptablePriorityQueue<Integer, Integer> defaultQ = new SortedListAdaptablePriorityQueue<Integer, Integer>();
		SortedListAdaptablePriorityQueue<Integer, Integer> intQ = new SortedListAdaptablePriorityQueue<Integer, Integer>(new integerComparator());

		System.out.println("Inserted entries to defaultQ are: \n");

		for (int i = 0; i <= n; ++i)
		{
			int s = 100 - i;
			int j = i + 1;
			defaultQ.insert (s, j);
			System.out.println(defaultQ.insert (s, j));
		}

		System.out.println("\nSorted entries by default are: \n");
		for (int i = 0; i <= n; ++i)
		{
			defaultQ.removeMin();
			System.out.println (defaultQ.removeMin());
		}

		System.out.println("Inserted entries to defaultQ are: \n");

		for (int i = 0; i <= n; ++i)
		{
			int s = 100 - i;
			int j = i + 1;
			intQ.insert (s, j);
			System.out.println(intQ.insert (s, j));
		}

		System.out.println("\nSorted entries by integerComparator are: \n");
		for (int i = 0; i <= n; ++i)
		{
			intQ.removeMin();
			System.out.println (intQ.removeMin());
		}
	}
}