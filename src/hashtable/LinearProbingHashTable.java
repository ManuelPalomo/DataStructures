package hashtable;

public class LinearProbingHashTable<K, V> implements HashTable<K, V> {
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;

	private Entry<K, V>[] table;
	private int occupiedCells;
	private int buckets;
	private float loadFactor;

	public LinearProbingHashTable() {
		super();
		table = (Entry<K, V>[]) new Entry<?, ?>[DEFAULT_INITIAL_CAPACITY];
		this.occupiedCells = 0;
		this.buckets = DEFAULT_INITIAL_CAPACITY;
		this.loadFactor = DEFAULT_LOAD_FACTOR;
	}

	public LinearProbingHashTable(int initialCapacity) {
		super();
		table = (Entry<K, V>[]) new Entry<?, ?>[initialCapacity];
		this.occupiedCells = 0;
		this.buckets = initialCapacity;
		this.loadFactor = DEFAULT_LOAD_FACTOR;
	}

	@Override
	public int hash(K key, int bucketNumber) {
		int hash;
		if (key == null) {
			hash = 0;
		} else {
			hash = Math.abs(key.hashCode());
		}
		return hash % bucketNumber;
	}

	@Override
	public void add(K key, V value) {
		int bucketDestination = this.hash(key, this.buckets);
		boolean inserted = false;
		for (int i = 0; i < this.buckets - bucketDestination; i++) {
			if (this.table[bucketDestination + i] == null) {
				this.table[bucketDestination + i] = new Entry<>(key, value);
				this.occupiedCells++;
				inserted = true;
				break;
			} else if (this.table[bucketDestination + i].getKey().equals(key)) {
				this.table[bucketDestination + i].setValue(value);
				inserted = true;
				break;
			}
		}
		if (!inserted) {
			rehashTableWithLeftover(key, value);
		} else {
			checkRehash();
		}
	}

	private void checkRehash() {
		if (this.occupiedCells / this.buckets >= this.loadFactor) {
			rehashTable();
		}
	}

	private void rehashTableWithLeftover(K leftOverKey, V leftoverValue) {
		rehashTable();
		this.add(leftOverKey, leftoverValue);
	}

	private void rehashTable() {
		int newSize = this.buckets * 2;
		Entry<K, V>[] newTable = (Entry<K, V>[]) new Entry<?, ?>[newSize];
		for (int i = 0; i < this.table.length; i++) {
			if (this.table[i] != null) {
				Entry<K, V> currentEntry = this.table[i];
				int bucketDestination = this.hash(currentEntry.getKey(), newSize);
				for (int x = 0; x < newSize - bucketDestination - 1; x++) {
					if (newTable[bucketDestination + x] == null) {
						newTable[bucketDestination + x] = currentEntry;
						break;
					}
				}
			}
		}
		this.buckets = newSize;
		this.table = newTable;
	}

	@Override
	public boolean exists(K key) {
		int bucketDestination = this.hash(key, this.buckets);
		for (int i = 0; i < this.buckets - bucketDestination; i++) {
			if (this.table[bucketDestination + i] == null) {
				return false;
			} else if (this.table[bucketDestination + i].getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public V get(K key) {
		int bucketDestination = this.hash(key, this.buckets);
		for (int i = 0; i < this.buckets - bucketDestination; i++) {
			if (this.table[bucketDestination + i] == null) {
				return null;
			} else if (this.table[bucketDestination + i].getKey().equals(key)) {
				return this.table[bucketDestination + i].getValue();
			}
		}
		return null;
	}

	@Override
	public void remove(K key) {
		int bucketDestination = this.hash(key, this.buckets);
		for (int i = 0; i < this.buckets - bucketDestination; i++) {
			if (this.table[bucketDestination] == null) {
				return;
			}
			if (this.table[bucketDestination].getKey().equals(key)) {
				this.table[bucketDestination] = null;
				this.realignTable(bucketDestination);
				this.occupiedCells--;
				return;
			}
		}
	}

	private void realignTable(int bucketDestination) {
		if (this.table[bucketDestination + 1] == null) {
			return;
		}
		for (int i = 1; i < this.buckets - bucketDestination; i++) {
			if (this.table[bucketDestination + i] == null) {
				return;
			}
			this.table[bucketDestination + (i - 1)] = this.table[bucketDestination + i];
		}
	}

	protected Entry<K, V>[] getTable() {
		return this.table;
	}

}
