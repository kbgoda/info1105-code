package lab3;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void empty() {
		assertEquals(new Stack<Integer>(), Fibonacci.getNumbers(-1));
	}
	
	@Test
	public void oneFib() {
		Stack<Integer>testOne = new Stack<Integer>();
		testOne.push(0);
		testOne.push(1);
		assertEquals(testOne, Fibonacci.getNumbers(1));
	}
	
	@Test
	public void firstThree() {
		Stack<Integer>testOne = new Stack<Integer>();
		testOne.push(0);
		testOne.push(1);
		testOne.push(1);
		testOne.push(2);
		assertEquals(testOne, Fibonacci.getNumbers(3));
		assertEquals(new Integer(2), testOne.pop());	
	}
	

}
