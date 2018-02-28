package lab3;

import java.util.Stack;

public class QuizOneRevision {

	public static void main(String[] args) {
		Stack<String>s = new Stack<String>();
		s.push("Fred");
		s.push("Jane");
		s.push("Pete");
		String s1 = s.pop();
		System.out.println(s1);
		String s2 = s.pop();
		System.out.println(s2);
		s.push("Alex");
		s.push("Kate");
		String s3 = s.pop();
		System.out.println(s3);
		System.out.println(s);

	}

}
