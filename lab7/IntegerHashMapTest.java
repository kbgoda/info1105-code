package lab7;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IntegerHashMapTest {
	

	@Test
	public void hashMap() {
		IntegerHashMap<String> kvPairs = new IntegerHashMap<String>(5);
		kvPairs.put(1, "One");
		kvPairs.put(2, "Two");
		kvPairs.put(3, "Three");
		kvPairs.put(4, "Four");
		kvPairs.put(50, "Five");
		assertEquals("Five", kvPairs.get(50));
		assertEquals("Three", kvPairs.remove(3));
		ArrayList<String> kvP = new ArrayList<String>();
		kvP.add("Five");
		kvP.add("One");
		kvP.add("Two");
		kvP.add("Four");
		assertEquals(kvP, kvPairs.values());
		ArrayList<Integer> keys = new ArrayList<Integer>();
		keys.add(0);
		keys.add(1);
		keys.add(2);
		keys.add(4);
		assertEquals(keys, kvPairs.keySet());
		assertEquals(4, kvPairs.size());
		kvPairs.entrySet();
	}
	
	@Test
	public void testSmallHashMap() {
		IntegerHashMap<String> kvPairs = new IntegerHashMap<String>(5);
		kvPairs.put(1, "One");
		kvPairs.put(2, "Two");
		kvPairs.put(100, "Five");
		assertEquals("Five", kvPairs.get(100));
	}
	
	 @Test
	  public void testCollision() {
		final ExpectedException exception = ExpectedException.none();
	    IntegerHashMap<String> map = new IntegerHashMap<String>(5);
	    map.put(1, "one");
	    exception.expect(RuntimeException.class);
	    assertEquals(exception, map.put(101, "oops"));
	  }
}
