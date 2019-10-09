package queue;

import linkedlist.TailPointerLinkedList;

public class LinkedListQueue<T> implements Queue<T> {
	TailPointerLinkedList<T> linkedList;

	public LinkedListQueue() {
		linkedList = new TailPointerLinkedList<>();
	}

	@Override
	public void enqueue(T value) {
		this.linkedList.append(value);
	}

	@Override
	public T dequeue() {
		return this.linkedList.popFirst();
	}

	@Override
	public boolean empty() {
		return this.linkedList.empty();
	}

	@Override
	public T peek() {
		return this.linkedList.front();
	}

}
