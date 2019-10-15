package hashtable;

/**
 * Data structure based around the efficient association of key/value pairs and
 * allows the retrieval of one value giving one key in constant time.
 * 
 * The key is transformed using a hash function and addressed to one of the
 * corresponding buckets where the pair is going to be stored
 *
 */
public interface HashTable<K, V> {
	/**
	 * Returns the bucket number in where the key should be stored
	 * 
	 * @param key
	 * @param bucketNumber
	 * @return int with the bucket address
	 */
	public int hash(K key, int bucketNumber);

	/**
	 * Stores the corresponding key/value in the hash table
	 * 
	 * @param key
	 * @param value
	 */
	public void add(K key, V value);

	/**
	 * Returns true if the key exists in the hash table
	 * 
	 * @param key
	 * @return boolean if key exists
	 */
	public boolean exists(K key);

	/**
	 * Returns the value of the given key if exists
	 * 
	 * @param key
	 * @return
	 */
	public V get(K key);

	/**
	 * Removes the corresponding key/pair if exists
	 * 
	 * @param key
	 */
	public void remove(K key);

}
