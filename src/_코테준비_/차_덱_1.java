package _코테준비_;

import java.util.Deque;
import java.util.LinkedList;

public class 차_덱_1 {
	public static boolean isValid(String s) {
		Deque<Character> stack = new LinkedList<>();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String s1 = "()";
		String s2 = "(()";
		System.out.println(s1 + " 올바른 괄호 문자열인가? " + isValid(s1)); // true
		System.out.println(s2 + " 올바른 괄호 문자열인가? " + isValid(s2)); // false
	}

}
