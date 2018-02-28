package lab7;

import java.util.ArrayList;

public class IntegerHashMap<V> implements Map<Integer, V> {

	private class HashMapEntry implements Entry<Integer, V> {

		private Integer key;
		private V value;

		public HashMapEntry(Integer key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public Integer getKey() {
			return key;
		}

		@Override
		public V getValue() {
			if(this.value == null) return null;
			return value;
		}
	}

	private HashMapEntry[] items;
	private int numberOfItems;
	private ArrayList<Integer> existingKeys;

	@SuppressWarnings("unchecked")
	public IntegerHashMap(int capacity) {
		items = (IntegerHashMap<V>.HashMapEntry[]) new IntegerHashMap.HashMapEntry[capacity];
		this.numberOfItems = 0;
		existingKeys = new ArrayList<Integer>();
	}

	// Hashes values
	private int hash(Integer key) {
		return key;
	}

	// Used to decide the index of the value
	private int compress(int hash) {
		return Math.abs(hash) % items.length;
	}

	@Override
	public int size() {
		return numberOfItems;
	}

	@Override
	public boolean isEmpty() {
		if (numberOfItems == 0)
			return true;
		return false;
	}

	@Override
	public V get(Integer key) {
		int hashedKey = hash(key);
		int index = compress(hashedKey);
		// If the index is not null then value is returned
		if(items[index] != null) {
			return items[index].getValue();
		}
		return null;
	}

	@Override
	public V put(Integer key, V value) {
		int hashedKey = hash(key);
		int index = compress(hashedKey);
		// If the index does not exist
		if(this.get(index) == null) {
			existingKeys.add(key);
			items[index] = new HashMapEntry(index, value);
			numberOfItems++;
		// If the index exists, we need to make sure that the key is the original and not a modulus equivalent one
		} else if (this.get(index) != null && existingKeys.contains(key)){
			V val = this.get(index);
			items[index] = new HashMapEntry(index, value);
			return val;
		// If the key does not exist, then a runtime exception is thrown
		} else {
			throw new RuntimeException();
		}
		return null;
	}

	@Override
	public V remove(Integer key) {
		// Removing a value in the HashMap
		int hashedKey = hash(key);
		int compressed = compress(hashedKey);
		if(this.get(compressed) != null) {
			V value = this.get(compressed);
			this.items[compressed] = null;
			numberOfItems--;
			return value;
		}
		return null;
	}

	@Override
	public Iterable<Integer> keySet() {
		// The keys of HashMap
		ArrayList<Integer> keys = new ArrayList<Integer>();
		for(IntegerHashMap<V>.HashMapEntry key : this.items) {
			if(key != null) keys.add(key.getKey());
		}
		return keys;
	}

	@Override
	public Iterable<V> values() {
		// The values of HashMap
		ArrayList<V> values = new ArrayList<V>();
		for(IntegerHashMap<V>.HashMapEntry value : this.items) {
			if(value != null) values.add(value.getValue());
		}
		return values;
	}

	@Override
	public Iterable<Entry<Integer, V>> entrySet() {
		// The entries of the HashMap
		ArrayList <Entry<Integer, V>> entrySets = new ArrayList<>();
		for(IntegerHashMap<V>.HashMapEntry entry : this.items) {
			if(entry != null) {
				entrySets.add(entry);
			}
		}
		return entrySets;
	}
	
}