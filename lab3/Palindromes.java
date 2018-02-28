package lab3;

import java.util.Stack; 

public class Palindromes {
	
	public Palindromes() {
	}
	
	public static boolean isPalindrome(String word) {
		if(word.length() >= 0) {
			// Creates a character stack
			Stack<Character> reversedLetters = new Stack<Character>();
			for(int i = 0; i < word.length(); i++) {
				reversedLetters.push(word.charAt(i));
			}
			int stackSize = reversedLetters.size();
			String revWord = "";
			for(int i = 0; i < stackSize; i++) {
				revWord += reversedLetters.pop();	
			}
			if(stringEquals(word, revWord)) return true;
		}
		return false;
	}
	
	public static boolean isPalindromeSentence(String sentence) {
		String lowerSentence = "";
		for(int i = 0; i < sentence.length(); i++) {
			char letter = sentence.charAt(i);
			if(!Character.isWhitespace(letter) && Character.isAlphabetic(letter)) {
				lowerSentence += Character.toLowerCase(letter);
			}
		}
		return isPalindrome(lowerSentence);
	}
	
	static boolean stringEquals(String word1, String word2) {
		if(word1.equals(word2)) return true;
		return false;
	}
}
