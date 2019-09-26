package arraylist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomArrayListTest {

	@Test
	void sizeTest() {
		CustomArrayList<Integer> testArrayList = new CustomArrayList<>();
		assertEquals(0, testArrayList.size());
		testArrayList.push(1);
		assertEquals(1, testArrayList.size());
		testArrayList.pop();
		assertEquals(0, testArrayList.size());
	}

	@Test
	void capacityTest() {
		CustomArrayList<Integer> testArrayWithoutSpecifiedCapacity = new CustomArrayList<>();
		assertEquals(16, testArrayWithoutSpecifiedCapacity.capacity());

		CustomArrayList<Integer> testArrayWithSpecifiedCapacity = new CustomArrayList<>(20);
		assertEquals(20, testArrayWithSpecifiedCapacity.capacity());
	}

	@Test
	void isEmptyTest() {
		CustomArrayList<Integer> testArrayList = new CustomArrayList<>();
		assertTrue(testArrayList.isEmpty());
		testArrayList.push(1);
		assertEquals(false, testArrayList.isEmpty());
	}

	@Test
	void getTest() {
		CustomArrayList<Integer> testArrayList = new CustomArrayList<>();
		Integer itemToInsert = 1;
		testArrayList.push(itemToInsert);
		assertEquals(itemToInsert, testArrayList.get(0));
		assertThrows(IndexOutOfBoundsException.class, () -> testArrayList.get(500));
	}

	@Test
	void pushTest() {
		CustomArrayList<Integer> testArrayList = new CustomArrayList<>();
		Integer itemToInsert = 1;
		testArrayList.push(itemToInsert);
		assertEquals(1, testArrayList.size());
		assertEquals(itemToInsert, testArrayList.get(0));
	}

	@Test
	public void insertTest() {
		CustomArrayList<Integer> testArrayList = new CustomArrayList<>();
		Integer itemToInsert = 1;
		testArrayList.push(2);
		testArrayList.push(3);
		testArrayList.push(4);
		testArrayList.insert(2, itemToInsert);

		assertEquals(itemToInsert, testArrayList.get(2));
		assertEquals(4, testArrayList.get(3));
		assertEquals(4, testArrayList.size());
		assertThrows(IndexOutOfBoundsException.class, () -> testArrayList.insert(500, itemToInsert));

		CustomArrayList<Integer> testArrayListInsertAtZero = new CustomArrayList<>();
		testArrayListInsertAtZero.push(2);
		testArrayListInsertAtZero.push(3);
		testArrayListInsertAtZero.push(4);
		testArrayListInsertAtZero.insert(0, itemToInsert);

		assertEquals(itemToInsert, testArrayListInsertAtZero.get(0));
		assertEquals(2, testArrayListInsertAtZero.get(1));
		assertEquals(4, testArrayListInsertAtZero.size());

		CustomArrayList<Integer> testArrayListInsertAtEnd = new CustomArrayList<>();
		testArrayListInsertAtEnd.push(2);
		testArrayListInsertAtEnd.push(3);
		testArrayListInsertAtEnd.push(4);
		testArrayListInsertAtEnd.insert(3, itemToInsert);

		assertEquals(itemToInsert, testArrayListInsertAtEnd.get(3));
		assertEquals(4, testArrayListInsertAtEnd.get(2));
		assertNull(testArrayListInsertAtEnd.get(5));
		assertEquals(4, testArrayListInsertAtEnd.size());
	}

	@Test
	public void prependTest() {
		CustomArrayList<Integer> testArrayList = new CustomArrayList<>();
		Integer itemToInsert = 1;
		Integer secondItemToInsert = 2;
		testArrayList.push(itemToInsert);
		testArrayList.prepend(secondItemToInsert);
		assertEquals(secondItemToInsert, testArrayList.get(0));
		assertEquals(2, testArrayList.size());
	}

	@Test
	public void popTest() {
		CustomArrayList<Integer> testArrayList = new CustomArrayList<>();
		Integer itemToInsert = 1;
		testArrayList.push(itemToInsert);
		assertEquals(itemToInsert, testArrayList.pop());
		assertEquals(0, testArrayList.size());
	}

	@Test
	public void deleteTest() {
		CustomArrayList<Integer> testArrayList = new CustomArrayList<>();
		testArrayList.push(1);
		assertThrows(IndexOutOfBoundsException.class, () -> testArrayList.delete(500));
		assertEquals(1, testArrayList.delete(0));
		assertEquals(0, testArrayList.size());

		CustomArrayList<Integer> testArrayListDeleteEnd = new CustomArrayList<>();
		testArrayListDeleteEnd.push(1);
		testArrayListDeleteEnd.push(2);
		testArrayListDeleteEnd.push(3);
		testArrayListDeleteEnd.push(4);
		assertEquals(4, testArrayListDeleteEnd.delete(3));
		assertEquals(3, testArrayListDeleteEnd.size());

	}

	@Test
	public void removeTest() {
		CustomArrayList<Integer> testArrayList = new CustomArrayList<>();
		Integer itemToRemove = 4;
		testArrayList.push(1);
		testArrayList.push(2);
		testArrayList.push(3);
		testArrayList.push(itemToRemove);
		testArrayList.push(itemToRemove);

		testArrayList.remove(itemToRemove);
		assertEquals(4, testArrayList.size());
		assertTrue(testArrayList.find(itemToRemove) != -1);

	}

	@Test
	public void findTest() {
		CustomArrayList<Integer> testArrayList = new CustomArrayList<>();
		Integer itemToFind = 4;
		testArrayList.push(1);
		testArrayList.push(2);
		testArrayList.push(3);
		testArrayList.push(itemToFind);
		testArrayList.push(itemToFind);

		assertEquals(3, testArrayList.find(itemToFind));
	}

}
