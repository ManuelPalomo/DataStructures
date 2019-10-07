package linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TailPointerLinkedListTest {

	@Test
	void sizeTest() {
		TailPointerLinkedList<Integer> testLinkedList = new TailPointerLinkedList<>();
		assertEquals(0, testLinkedList.size());
		testLinkedList.append(1);
		assertEquals(1, testLinkedList.size());
	}

	@Test
	void emptyTest() {
		TailPointerLinkedList<Integer> testLinkedList = new TailPointerLinkedList<>();
		assertTrue(testLinkedList.empty());
		testLinkedList.append(1);
		assertFalse(testLinkedList.empty());
	}

	@Test
	void getTest() {
		TailPointerLinkedList<Integer> testLinkedList = new TailPointerLinkedList<>();
		testLinkedList.append(1);
		testLinkedList.append(2);
		testLinkedList.append(3);
		testLinkedList.append(4);
		testLinkedList.append(5);
		assertEquals(1, testLinkedList.get(0));
		assertEquals(3, testLinkedList.get(2));
		assertEquals(5, testLinkedList.get(4));
		assertThrows(IndexOutOfBoundsException.class, () -> testLinkedList.get(1000));
	}

	@Test
	void prependTest() {
		TailPointerLinkedList<Integer> testLinkedList = new TailPointerLinkedList<>();
		testLinkedList.append(1);
		testLinkedList.append(2);
		testLinkedList.prepend(3);
		assertEquals(3, testLinkedList.get(0));
		assertEquals(1, testLinkedList.get(1));
		assertEquals(3, testLinkedList.size());
	}

	@Test
	void popFirstTest() {
		TailPointerLinkedList<Integer> testLinkedList = new TailPointerLinkedList<>();
		testLinkedList.append(1);
		testLinkedList.append(2);
		testLinkedList.append(3);
		assertEquals(1, testLinkedList.popFirst());
		assertEquals(2, testLinkedList.size());
		assertEquals(2, testLinkedList.popFirst());
		assertEquals(1, testLinkedList.size());
	}

	@Test
	void appendTest() {
		TailPointerLinkedList<Integer> testLinkedList = new TailPointerLinkedList<>();
		testLinkedList.append(1);
		assertEquals(1, testLinkedList.size());
		testLinkedList.append(2);
		assertEquals(2, testLinkedList.size());
		assertEquals(1, testLinkedList.get(0));
	}

	@Test
	void popTest() {
		TailPointerLinkedList<Integer> testLinkedList = new TailPointerLinkedList<>();
		testLinkedList.append(1);
		testLinkedList.append(2);
		testLinkedList.append(3);

		assertEquals(3, testLinkedList.pop());
		assertEquals(2, testLinkedList.size());
		assertEquals(2, testLinkedList.pop());
		assertEquals(1, testLinkedList.size());
		assertEquals(1, testLinkedList.pop());
		assertTrue(testLinkedList.empty());
	}

	@Test
	void frontTest() {
		TailPointerLinkedList<Integer> testLinkedList = new TailPointerLinkedList<>();
		testLinkedList.append(1);
		testLinkedList.append(2);
		assertEquals(1, testLinkedList.front());
	}

	@Test
	void backTest() {
		TailPointerLinkedList<Integer> testLinkedList = new TailPointerLinkedList<>();
		testLinkedList.append(1);
		testLinkedList.append(2);
		assertEquals(2, testLinkedList.back());
	}

	@Test
	void insertTest() {
		TailPointerLinkedList<Integer> testLinkedList = new TailPointerLinkedList<>();
		testLinkedList.append(1);
		testLinkedList.append(2);
		testLinkedList.insert(1, 3);
		assertEquals(3, testLinkedList.size());
		assertEquals(3, testLinkedList.get(1));
		assertEquals(2, testLinkedList.get(2));
		assertEquals(2, testLinkedList.back());
		assertThrows(IndexOutOfBoundsException.class, () -> testLinkedList.insert(100, 1));
	}

	@Test
	void removeTest() {
		TailPointerLinkedList<Integer> testLinkedList = new TailPointerLinkedList<>();
		testLinkedList.append(1);
		testLinkedList.append(2);
		testLinkedList.append(3);
		assertEquals(3, testLinkedList.remove(2));
		assertEquals(2, testLinkedList.size());
		assertEquals(1, testLinkedList.remove(0));
		assertEquals(1, testLinkedList.size());
		assertEquals(2, testLinkedList.remove(0));
		assertTrue(testLinkedList.empty());
	}

	@Test
	void reverseTest() {
		TailPointerLinkedList<Integer> testLinkedList = new TailPointerLinkedList<>();
		testLinkedList.append(1);
		testLinkedList.append(2);
		testLinkedList.append(3);
		testLinkedList.reverse();
		assertEquals(3, testLinkedList.get(0));
		assertEquals(2, testLinkedList.get(1));
		assertEquals(1, testLinkedList.get(2));
	}

	@Test
	void valueNFromEndTest() {
		TailPointerLinkedList<Integer> testLinkedList = new TailPointerLinkedList<>();
		testLinkedList.append(1);
		testLinkedList.append(2);
		testLinkedList.append(3);
		assertEquals(2, testLinkedList.valueNFromEnd(1));
	}

	@Test
	void removeItemTest() {
		TailPointerLinkedList<Integer> testLinkedList = new TailPointerLinkedList<>();
		testLinkedList.append(1);
		testLinkedList.append(2);
		testLinkedList.append(3);
		testLinkedList.append(4);
		testLinkedList.removeItem(3);
		assertEquals(3, testLinkedList.size());
		assertEquals(3, testLinkedList.get(3));
	}

}
