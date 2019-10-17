package hashtable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinearProbingHashTableTest {

	@Test
	public void hashTest() {
		LinearProbingHashTable<String, String> testHashTable = new LinearProbingHashTable<>();
		assertEquals(2, testHashTable.hash("Test", 16));
		assertEquals(5, testHashTable.hash("Banana", 16));
		assertEquals(3, testHashTable.hash("HelloKey", 16));
	}

	@Test
	public void addTestInsertion() {
		LinearProbingHashTable<String, String> testHashTable = new LinearProbingHashTable<>();
		testHashTable.add("HelloKey", "Hello");
		assertTrue(testHashTable.exists("HelloKey"));
		assertEquals("Hello", testHashTable.get("HelloKey"));
	}

	@Test
	public void addTestUpdateSameKey() {
		LinearProbingHashTable<String, String> testHashTable = new LinearProbingHashTable<>();
		testHashTable.add("HelloKey", "Hello");
		assertTrue(testHashTable.exists("HelloKey"));
		assertEquals("Hello", testHashTable.get("HelloKey"));
		testHashTable.add("HelloKey", "changed");
		assertEquals("changed", testHashTable.get("HelloKey"));
	}

	@Test
	public void addTestRehashTrigger() {
		// To trigger it, in order to reach the default load factor threshold (0.75) we
		// need to insert >13 elements (13/16 = 0.875)
		LinearProbingHashTable<String, String> testHashTable = new LinearProbingHashTable<>();
		testHashTable.add("Element1", "Test1");
		testHashTable.add("Element2", "Test1");
		testHashTable.add("Element3", "Test1");
		testHashTable.add("Element4", "Test1");
		testHashTable.add("Element5", "Test1");
		testHashTable.add("Element6", "Test1");
		testHashTable.add("Element7", "Test1");
		testHashTable.add("Element8", "Test1");
		testHashTable.add("Element9", "Test1");
		testHashTable.add("Element10", "Test1");
		testHashTable.add("Element11", "Test1");
		testHashTable.add("Element12", "Test1");
		testHashTable.add("Element13", "Test1");

		//Elements that don't fit force a rehash, so the rehash will be forced twice
		assertEquals(64, testHashTable.getTable().length);
		assertEquals("Test1", testHashTable.get("Element1"));
		assertEquals("Test1", testHashTable.get("Element7"));
		assertEquals("Test1", testHashTable.get("Element13"));
	}

	@Test
	public void existsTest() {
		LinearProbingHashTable<String, String> testHashTable = new LinearProbingHashTable<>();
		testHashTable.add("Element1", "Test1");
		assertTrue(testHashTable.exists("Element1"));
		assertFalse(testHashTable.exists("Element2"));
	}

	@Test
	public void getTest() {
		LinearProbingHashTable<String, String> testHashTable = new LinearProbingHashTable<>();
		testHashTable.add("Element1", "Test1");
		testHashTable.add("Element2", "Test1");

		assertEquals("Test1", testHashTable.get("Element1"));
		assertNull(testHashTable.get("NotExists"));
	}

	@Test
	public void removeTest() {
		LinearProbingHashTable<String, String> testHashTable = new LinearProbingHashTable<>();
		testHashTable.add("Element1", "Test1");
		testHashTable.add("Element2", "Test1");

		testHashTable.remove("Element1");
		testHashTable.remove("NotExistsElement");

		assertFalse(testHashTable.exists("Element1"));
		assertTrue(testHashTable.exists("Element2"));
	}

}
