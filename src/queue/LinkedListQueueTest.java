package queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListQueueTest {

	@Test
	void enqueueTest() {
		LinkedListQueue<Integer> testQueue = new LinkedListQueue<>();
		testQueue.enqueue(1);
		assertFalse(testQueue.empty());
		assertEquals(1, testQueue.dequeue());
		assertTrue(testQueue.empty());
	}

	@Test
	void dequeuTest() {
		LinkedListQueue<Integer> testQueue = new LinkedListQueue<>();
		assertEquals(null, testQueue.dequeue());
		testQueue.enqueue(1);
		assertEquals(1, testQueue.dequeue());
	}

	@Test
	void emptyTest() {
		LinkedListQueue<Integer> testQueue = new LinkedListQueue<>();
		assertTrue(testQueue.empty());
		testQueue.enqueue(1);
		assertFalse(testQueue.empty());
	}

	@Test
	void peekTest() {
		LinkedListQueue<Integer> testQueue = new LinkedListQueue<>();
		assertEquals(null, testQueue.peek());
		testQueue.enqueue(1);
		assertEquals(1, testQueue.peek());
	}

}
