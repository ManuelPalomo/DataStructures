package queue;

/**
 * Data structure which stores data in a First In First Out (FIFO) fashion, can
 * only insert in the back and read on the front
 * 
 * @param <T>
 */
public interface Queue<T> {
	public void enqueue(T value);

	public T dequeue();

	public boolean empty();

	public T peek();
}
