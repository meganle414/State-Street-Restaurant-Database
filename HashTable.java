// --== CS400 File Header Information ==--
// Name: Megan Le
// Email: mle25@wisc.edu
// Team: AF
// TA: Sophie Stephenson
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
import java.util.NoSuchElementException;
import java.util.LinkedList;

public class HashTable<K, V> implements Table<K, V> {
	@SuppressWarnings("hiding")
	public class KeyValuePair<K, V> {
		private K key;
		private V value;

		/*
		 * Default constructor for KeyValuePair
		 */
		public KeyValuePair() {
			key = null;
			value = null;
		}

		/*
		 * Constructor for KeyValuePair given KeyType and ValueType
		 * 
		 * @param KeyType key
		 * 
		 * @param ValueType value
		 */
		public KeyValuePair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		/*
		 * Getter method for key
		 * 
		 * @return key
		 */
		public K getKey() {
			return key;
		}

		/*
		 * Getter method for value
		 * 
		 * @return value
		 */
		public V getValue() {
			return value;
		}
	}

	private LinkedList<KeyValuePair<K, V>>[] buckets;
	private int size = 0;
	private int capacity;

	/*
	 * constructor for Hash Table Map with specified capacity
	 * 
	 * @param capacity capacity of Hash Table map
	 */
	@SuppressWarnings("unchecked")
	public HashTable(int capacity) {
		this.capacity = capacity;
		buckets = new LinkedList[capacity];
		createBucketsArray(buckets);
	}

	/*
	 * constructor for Hash Table Map with default capacity 10
	 */
	public HashTable() { // with default capacity = 10
		this(10);
	}

	/*
	 * Checks if hashTableMap is at 80% capacity or greater
	 * 
	 * @return true if at 80% capacity or greater, false if not at 80% capacity or
	 * greater
	 */
	private boolean checkIf80OrGreater() {
		if (((double) size() / capacity) >= 0.80) {
			return true;
		}
		return false;
	}

	/*
	 * Doubles the capacity of the current buckets LinkedList
	 */
	@SuppressWarnings("unchecked")
	private void grow() {
		capacity *= 2;
		LinkedList<KeyValuePair<K, V>>[] newBuckets;
		newBuckets = new LinkedList[capacity];
		createBucketsArray(newBuckets);
		for (LinkedList<KeyValuePair<K, V>> bucket : buckets) {
			for (KeyValuePair<K, V> KVPair : bucket) {
				int index = Math.abs(KVPair.getKey().hashCode()) % capacity;
				newBuckets[index].push(KVPair);
			}
		}
		buckets = newBuckets;
		createBucketsArray(buckets);
	}

	/*
	 * Figures out the index that the key should be in based on the key's hash code
	 * function
	 * 
	 * @return index
	 */
	private int getIndex(K key) {
		if (capacity != 0) {
			return Math.abs(key.hashCode()) % capacity;
		}
		return 0;
	}

	/*
	 * Creates buckets for each of the Hash Table Maps
	 * 
	 * @param buckets the LinkedList we want to create buckets for
	 */
	private void createBucketsArray(LinkedList<KeyValuePair<K, V>>[] buckets) {
		for (int i = 0; i < capacity; i++) {
			buckets[i] = new LinkedList<KeyValuePair<K, V>>();
		}
	}

	/*
	 * Inserts a key value pair into the Hash Table map unless there is an existing
	 * key type with the same key
	 * 
	 * @param KeyType key
	 * 
	 * @param ValueType value
	 * 
	 * @return true if successfully added, false if not
	 */
	@Override
	public boolean put(K key, V value) {
		int index = getIndex(key);
		if (buckets.length != 0) {
			LinkedList<KeyValuePair<K, V>> bucket = buckets[index];
			if (bucket != null) {
				for (KeyValuePair<K, V> KVPair : bucket) {
					if (KVPair != null) {
						if (KVPair.getKey().equals(key)) {
							return false;
						}
					}
				}
			}

			bucket.push(new KeyValuePair<K, V>(key, value));
			size++;
			if (checkIf80OrGreater()) {
				grow();
			}
			return true;
		}
		return false;
	}

	/*
	 * Returns the value of a specific key value pair when given the key
	 * 
	 * @param KeyType key
	 * 
	 * @throws NoSuchElementException when there is no key value pair with given key
	 * 
	 * @return value of a specific key value pair
	 */
	@Override
	public V get(K key) throws NoSuchElementException {
		int index = getIndex(key);
		for (KeyValuePair<K, V> KVPair : buckets[index]) {
			if (KVPair.getKey().equals(key)) {
				return KVPair.getValue();
			}
		}
		throw new NoSuchElementException();
	}

	/*
	 * Returns the size of the Hash Table Map
	 * 
	 * @return int of size of Hash Table Map
	 */
	@Override
	public int size() {
		return size;
	}

	/*
	 * Returns a boolean value of whether the Hash Table Map contains a certain key
	 * passed or not
	 * 
	 * @param KeyType key
	 * 
	 * @return boolean true if Hash Table Map contains a specific key, false if it
	 * doesn't
	 */
	@Override
	public boolean containsKey(K key) {
		int index = getIndex(key);
		if (buckets.length != 0) {
			for (KeyValuePair<K, V> KVPair : buckets[index]) {
				if (KVPair.getKey().equals(key)) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * Removes a specific key from the Hash Table Map
	 * 
	 * @param KeyType key
	 * 
	 * @return ValueType value of key value pair
	 */
	@Override
	public String[] remove(K key) {
		int index = getIndex(key);
		LinkedList<KeyValuePair<K, V>> bucket = buckets[index];
		for (int i = 0; i < bucket.size(); i++) {
			KeyValuePair<K, V> KVPair = bucket.get(i);
			if (KVPair.getKey().equals(key)) {
				V valueRemoved = KVPair.getValue();
				bucket.remove(i);
				size--;
				return (String[]) valueRemoved;
			}
		}
		return null;
	}

	/*
	 * Clears the Hash Table Map
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		buckets = new LinkedList[capacity];
		size = 0;
		createBucketsArray(buckets);
	}

}
