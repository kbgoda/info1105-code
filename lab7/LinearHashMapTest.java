package lab7;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinearHashMapTest {

	@Test
	public void stringHashMap() {
		LinearHashMap<String, String> strHashMap = new LinearHashMap<String, String>(5);
		strHashMap.put("One", "StringValue");
		assertEquals("StringValue", strHashMap.get("One"));
		strHashMap.remove("One");
		assertEquals(0, strHashMap.size());
	}
	// For collisions
	@Test
	public void intHashMap() {
		LinearHashMap<Integer, String> intHashMap = new LinearHashMap<Integer, String>(380);
		intHashMap.put(380, "lol");
		System.out.println(intHashMap.get(0));
	}
	
	@Test
	public void testCollisions() {
		LinearHashMap<Integer, Integer> hm = new LinearHashMap<Integer, Integer>(4);
		hm.put(0, 0);
		hm.put(1, 1);
		assertEquals(Integer.valueOf(0), hm.get(0));
		hm.put(4, 4);
		System.out.println(hm.put(5, 5));
		System.out.println(hm.put(5, 6));
		assertEquals(Integer.valueOf(4), hm.remove(4));
		assertEquals(3, hm.size());
		assertEquals(Integer.valueOf(0), hm.get(0));
		System.out.println(hm.keySet());
	}
	
//	@Test
//	public void nullHashMap() {
//		LinearHashMap<String, String> nullHM = new LinearHashMap<String, String>(5);
//		nullHM.put(null, null);
//		System.out.println(nullHM.size());
//	}

}
