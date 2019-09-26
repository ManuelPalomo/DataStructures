package arraylist;

public class CustomArrayList<T> implements ArrayList<T> {
	private static final int DEFAULT_CAPACITY = 16;

	private int startingCapacity;
	private int size;
	private T[] array;

	public CustomArrayList() {
		super();
		this.array = (T[]) new Object[DEFAULT_CAPACITY];
		this.size = 0;
		this.startingCapacity = DEFAULT_CAPACITY;
	}

	public CustomArrayList(int startingCapacity) {
		super();
		this.array = (T[]) new Object[startingCapacity];
		this.size = 0;
		this.startingCapacity = startingCapacity;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public int capacity() {
		return this.array.length;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public T get(int index) {
		if (!isIndexValid(index))
			throw new IndexOutOfBoundsException();
		return this.array[index];
	}

	@Override
	public void push(T item) {
		if (!newElementFits()) {
			resize((int) Math.pow(startingCapacity, 2));
		}
		this.array[size] = item;
		size++;
	}

	@Override
	public void insert(int index, T item) {
		if (!isIndexValid(index)) {
			throw new IndexOutOfBoundsException();
		}
		if (!newElementFits()) {
			resize((int) Math.pow(startingCapacity, 2));
		}
		for (int i = size; i > index; i--) {
			this.array[i] = this.array[i - 1];
		}
		this.array[index] = item;
		size++;

	}

	@Override
	public void prepend(T item) {
		if (!newElementFits()) {
			resize((int) Math.pow(startingCapacity, 2));
		}
		for (int i = size; i > 0; i--) {
			this.array[i] = this.array[i - 1];
		}
		this.array[0] = item;
		size++;
	}

	@Override
	public T pop() {
		T poppedItem = this.array[size - 1];
		this.array[size - 1] = null;
		size--;
		if (isReductionNeeded()) {
			this.resize(capacity() / 2);
		}
		return poppedItem;
	}

	@Override
	public T delete(int index) {
		if (!isIndexValid(index)) {
			throw new IndexOutOfBoundsException();
		}

		T deletedElement = this.array[index];
		for (int i = index; i < size; i++) {
			this.array[i] = this.array[i + 1];
		}
		size--;

		if (isReductionNeeded()) {
			this.resize(capacity() / 2);
		}
		return deletedElement;
	}

	@Override
	public void remove(T item) {
		for (int i = 0; i < size; i++) {
			if (this.array[i].equals(item)) {
				this.delete(i);
				return;
			}
		}
	}

	@Override
	public int find(T item) {
		for (int i = 0; i < size; i++) {
			if (this.array[i].equals(item))
				return i;
		}
		return -1;
	}

	private boolean isIndexValid(int index) {
		return index >= 0 || index < this.size - 1;
	}

	private boolean newElementFits() {
		return this.size + 1 < this.capacity();
	}

	private void resize(int newCapacity) {
		T[] newArray = (T[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newArray[i] = this.array[i];
		}
		this.array = newArray;
	}

	private boolean isReductionNeeded() {
		return this.size() == capacity() / 4;
	}

}
