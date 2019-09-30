package arraylist;

/**
 * Data structure based around an internal array that grows/shrinks depending on
 * the needs. All the elements are kept contiguous in memory
 * 
 * The internal starting capacity revolves around multiples, if not specified in
 * the constructor, the starting capacity is 16 and if this capacity is
 * exceeded, the next capacity is going to be starting capacity ^ 2
 * 
 * When elements are popped/deleted, if the remaining size is 1/4 of the initial capacity
 * it should be reduced to half capacity.
 * 
 * @param <T>
 */
public interface ArrayList<T> {
	/**
	 * Get the number of elements inside the ArrayList
	 * 
	 * @return integer containing the number of elements
	 */
	public int size();

	/**
	 * Get the total capacity of the array contained in the ArrayList
	 * 
	 * @return integer containing the capacity
	 */
	public int capacity();

	/**
	 * Checks if the ArrayList is empty
	 * 
	 * @return boolean true if empty, false if not
	 */
	public boolean isEmpty();

	/**
	 * Gets the item at index position
	 * 
	 * @param index to retrieve the item
	 * @throws ArrayIndexOutOfBoundsException
	 * @return T element if exists, null if not
	 */
	public T get(int index);

	/**
	 * Adds the item at the end of the array size
	 * 
	 * @param item to be inserted
	 */
	public void push(T item);

	/**
	 * Adds the item at the specified index position, can only add at indexes
	 * between 0 or size()
	 * 
	 * @param index in which the item should be inserted
	 * @param item  to be inserted
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void insert(int index, T item);

	/**
	 * Adds item at the start of the Array;
	 * 
	 * @param item to be inserted
	 */
	public void prepend(T item);

	/**
	 * Returns the last element of the array, then deletes it
	 * 
	 * @return T item if exists, null if not
	 */
	public T pop();

	/**
	 * Deletes the item at index position
	 * 
	 * @param index to be deleted
	 * @return T element deleted, or null if no element was present
	 */
	public T delete(int index);

	/**
	 * Deletes the item at the specified position
	 * 
	 * @param item to be removed
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void remove(T item);

	/**
	 * Returns the index in which the first instance of the item is found, or -1 if
	 * not
	 * 
	 * @param item to be found
	 * @return int containing the array, or -1 if not
	 */
	public int find(T item);
}
