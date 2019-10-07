package linkedlist;

public class TailPointerLinkedList<T> implements LinkedList<T> {

	private class Node<T> {
		private T value;
		private Node<T> next;

		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
	}

	private int size;
	private Node<T> head;
	private Node<T> tail;

	public TailPointerLinkedList() {
		super();
		this.head = this.tail = null;
		this.size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean empty() {
		return this.size == 0;
	}

	@Override
	public T get(int index) {
		if (!isIndexValid(index)) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			return this.head.value;
		}

		if (index == this.size - 1) {
			return this.tail.value;
		}

		Node<T> pointer = this.head;
		for (int i = 0; i < size; i++) {
			if (index == i) {
				return pointer.value;
			}
			pointer = pointer.next;
		}
		return null;
	}

	private boolean isIndexValid(int index) {
		return index >= 0 && index <= this.size - 1;
	}

	@Override
	public void prepend(T item) {
		Node<T> newNode;
		if (this.empty()) {
			newNode = new Node<>(item, null);
			head = tail = newNode;
		} else {
			newNode = new Node<>(item, head.next);
			head = newNode;
		}
		size++;
	}

	@Override
	public T popFirst() {
		if (this.empty()) {
			return null;
		}

		Node<T> poppedItem = this.head;

		if (this.size == 1) {
			this.head = this.tail = null;
			size--;
			return poppedItem.value;
		}

		head = head.next;
		size--;
		return poppedItem.value;

	}

	@Override
	public void append(T item) {
		Node<T> nodeToAppend = new Node<>(item, null);
		if (this.empty()) {
			this.head = this.tail = nodeToAppend;
			size++;
		} else {
			this.tail.next = nodeToAppend;
			this.tail = nodeToAppend;
			size++;
		}
	}

	@Override
	public T pop() {
		if (this.empty()) {
			return null;
		} else {
			Node<T> poppedItem = this.tail;
			Node<T> pointer = this.head;
			for (int i = 0; i < this.size() - 2; i++) {
				pointer = pointer.next;
			}
			this.tail = pointer;
			pointer.setNext(null);
			size--;
			return poppedItem.value;
		}
	}

	@Override
	public T front() {
		return this.head.value;
	}

	@Override
	public T back() {
		return this.tail.value;
	}

	@Override
	public void insert(int index, T item) {
		if (!isIndexValid(index)) {
			throw new IndexOutOfBoundsException();
		} else {
			Node<T> pointer = this.head;
			for (int i = 0; i < index - 1; i++) {
				pointer = pointer.getNext();
			}
			Node<T> insertedNode = new Node<>(item, pointer.next);
			pointer.setNext(insertedNode);
			size++;

			if (this.size - 1 == index) {
				this.tail = insertedNode;
			}
		}
	}

	@Override
	public T remove(int index) {
		if (!isIndexValid(index)) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			return popFirst();
		}

		if (index == this.size - 1) {
			return pop();
		}
		Node<T> pointer = this.head;
		for (int i = 0; i < index - 1; i++) {
			pointer = pointer.getNext();
		}
		T removedElement = pointer.getNext().getValue();
		pointer.setNext(pointer.getNext().getNext());
		size--;
		return removedElement;

	}

	@Override
	public void reverse() {
		Node<T> previousPointer;
		Node<T> actualPointer;
		Node<T> nextPointer;

		previousPointer = nextPointer = null;
		actualPointer = this.head;
		this.tail = this.head;
		while (actualPointer != null) {
			nextPointer = actualPointer.getNext();
			actualPointer.setNext(previousPointer);
			previousPointer = actualPointer;
			actualPointer = nextPointer;
		}
		this.head = previousPointer;

	}

	@Override
	public T valueNFromEnd(int number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeItem(T item) {
		// TODO Auto-generated method stub
	}

}
