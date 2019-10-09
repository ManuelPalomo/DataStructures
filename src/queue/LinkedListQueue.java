package queue;

import linkedlist.TailPointerLinkedList;

public class LinkedListQueue<T> implements Queue<T> {
	TailPointerLinkedList<T> linkedList;

	public LinkedListQueue() {
		linkedList = new TailPointerLinkedList<>();
	}

	@Override
	public void enqueue(T value) {
		// TODO Auto-generated method stub

	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

}
