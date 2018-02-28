package lab1;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

public class HailstoneTest extends Hailstone {
	
	Hailstone obj = new Hailstone();
	
	@Test
	public void testNoSequence() {
		assertEquals(Arrays.asList(1), obj.hailstone(1));
	}
	
	@Test
	public void testShortSequence() {
		assertEquals(Arrays.asList(4, 2, 1), obj.hailstone(4));
	}
	
	@Test
	public void testLongSequence() {
		assertEquals(Arrays.asList(7, 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1), hailstone(7));
	}
	
	@Test
	public void testMediumSequence() {
		assertEquals(Arrays.asList(6, 3, 10, 5, 16, 8, 4, 2, 1), obj.hailstone(6));
	}

}
