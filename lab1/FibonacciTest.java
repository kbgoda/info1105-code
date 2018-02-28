package lab1;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest extends Fibonacci {

	@Test
	public void test() {
		assertEquals(377, fibonacci(14));
		assertEquals(0, fibonacci(0));
	}
}
