package lab3;

import java.util.Stack;

public class Fibonacci {
	/**
	 * Given a number n, return a stack containing the Fibonacci numbers from
	 * f(0) up to and including f(n)
	 */

	private static Stack<Integer> fibNums = new Stack<Integer>();

	public static Stack<Integer> getNumbers(int n) {
		if (n < 0) {
			return new Stack<Integer>();
		} else if (n == 1) {
			fibNums.push(0);
			fibNums.push(1);
			
		} else if(n == 0) {
			fibNums.push(0);
		} else {
			fibNums.clear();
			fibNums.push(0);
			fibNums.push(1);
			int endLoop = 1;
			// Iterates till we reach last number
			while (endLoop < n) {
				// Pops does operation, and re-adds to the stack
				int fib1 = fibNums.pop();
				int fib2 = fibNums.pop();
				int z = fib1 + fib2;
				fibNums.push(fib2);
				fibNums.push(fib1);
				fibNums.push(z);
				endLoop++;
			}
		}
		return fibNums;
	}
}
