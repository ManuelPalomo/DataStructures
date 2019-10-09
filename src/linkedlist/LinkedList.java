package linkedlist;

/**
 * 
 * Data structure based around interconnected nodes that contain a pointer to
 * the next node, and a value. The structure is used by providing a pointer to
 * the first node.
 * 
 * All indexes starts at 0.
 *
 * @param <T>
 */
public interface LinkedList<T> {

	/**
	 * Get the number of elements inside the LinkedList
	 * 
	 * @return int containing the number of elements
	 */
	public int size();

	/**
	 * Returns true if this LinkedList has no elements;
	 * 
	 * @return boolean true if empty, false if not
	 */
	public boolean empty();

	/**
	 * Returns the node value at specified index
	 * 
	 * @param index int containing the index to be retrieved
	 * @return T value of the node
	 * @throws IndexOutOfBoundsException
	 */
	public T get(int index);

	/**
	 * Adds item to the start of the LinkedList
	 * 
	 * @param item to be prepended
	 */
	public void prepend(T item);

	/**
	 * Removes and return the first element of the LinkedList
	 * 
	 * @return T item popped
	 */
	public T popFirst();

	/**
	 * Adds item to the end of the LinkedList
	 * 
	 * @param item to be appended
	 */
	public void append(T item);

	/**
	 * Removes and returns the last element of the LinkedList
	 * 
	 * @return T item popped
	 */
	public T pop();

	/**
	 * Returns the value at the start of the LinkedList
	 * 
	 * @return T item at the start
	 */
	public T front();

	/**
	 * Returns the value at the back of the LinkedList
	 * 
	 * @return T item at the end
	 */
	public T back();

	/**
	 * Inserts T item at index
	 * 
	 * @param index in which the item should be inserted
	 * @param item  to be inserted
	 * @throws IndexOutOfBoundsException
	 */
	public void insert(int index, T item);

	/**
	 * Removes the node at the index position
	 * 
	 * @param index of node to be removed
	 * @return T removed element
	 * @throws IndexOutOfBoundsException
	 */
	public T remove(int index);

	/**
	 * Reverses the list, so the first element is the last one and all the elements
	 * of the List point backwards
	 * 
	 * (HEAD -> 1 -> 2 -> 3 -> 4 -> null) becomes (HEAD -> 4 -> 3 -> 2 -> 1 -> null)
	 */
	public void reverse();

	/**
	 * Returns the Nth value from end
	 * 
	 * @param number of nth value
	 * @return nth value
	 * @throws IndexOutOfBoundsException if the number exceeds the total number of
	 *                                   elements in the LinkedList
	 */
	public T valueNFromEnd(int number);

	/**
	 * Removes the first occurrence of specified item
	 * 
	 * @param item to be removed
	 */
	public void removeItem(T item);
}
