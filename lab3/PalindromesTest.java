package lab3;

import static org.junit.Assert.*;
import org.junit.Test;

public class PalindromesTest extends Palindromes {

	@Test
	public void testEmptyString() {
		assertEquals(true, isPalindrome(""));
	}
		
	@Test
	public void testBasicPalindromes() {
		assertEquals(true, isPalindrome("eye"));
		assertEquals(true, isPalindrome("racecar"));
	}
	
	@Test
	public void testBasicNonPalindromes() {
		assertEquals(false, isPalindrome("hello"));
		assertEquals(false, isPalindrome("book"));
	}
	
	@Test
	public void testCase() {
		assertEquals(true, isPalindrome("EyE"));
		assertEquals(false, isPalindrome("Eye"));
	}
	
	@Test
	public void testisPalindromeSentence() {
		assertEquals(true, isPalindromeSentence("Madam, I'm Adam"));
	}


}
