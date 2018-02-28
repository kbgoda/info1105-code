package lab6;

import static org.junit.Assert.*;

import org.junit.Test;

public class BstSimpleSortedMapTest {
	
	BstSimpleSortedMap map = new BstSimpleSortedMap();

	@Test
	public void SimpleMap() {
		map.put(5, "B");
		assertEquals("B", map.put(5, "A"));
		map.put(3, "D");
		assertEquals("D", map.put(3, "B"));
		map.put(7, "C");
		map.put(1, "D");
		map.put(4, "E");
		map.put(6, "E");
		map.put(8, null);
		assertEquals("A", map.get(5));
		assertEquals("C", map.get(7));
		assertEquals("E", map.get(4));
		assertEquals("B", map.get(3));
		assertEquals(7, map.size());
		assertNull(map.get(10));
		assertNull(map.get(8));
		assertEquals(null, map.put(8, "F"));
		System.out.println(map.size());
	}

}
