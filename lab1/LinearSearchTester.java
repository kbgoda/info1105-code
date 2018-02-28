package lab1;

import static org.junit.Assert.*;
import java.util.Scanner;

import org.junit.Test;

public class LinearSearchTester {

	private Scanner input;

	@Test
	public void test() {
		input = new Scanner(System.in);
		String numbers = "";
		Integer[] linearMode = new Integer[10];
		
		for(int i = 0; i < linearMode.length; i++) {
			linearMode[i] = Integer.valueOf((int) ((Math.random() * 10) + 1));
		}
		// Tells us what numbers are in the Integer array
		for(Integer value : linearMode) {
			numbers = numbers + value + ", ";
		}
		numbers = numbers.substring(0, numbers.length() - 2);
		System.out.print(numbers);
		
		// Object of type LinearSearchableArray
		LinearSearchableArray<Integer>hayStack = new LinearSearchableArray<Integer>(linearMode);
		
		System.out.print("\nType a number to find: ");
		Integer num = input.nextInt();
		assertEquals(num, hayStack.search(num));
	}

}
