package BaekJoon.notyet;

import java.util.Scanner;
import java.util.Stack;

public class _1662_압축3 { //gpt 이용했음. 이건 stack 이용하는거

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();

		System.out.println(alzip(S));
	}

	private static int alzip(String s) {
		Stack<Integer> stack = new Stack<>();
		int nowLen = 0;
		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch) && i + 1 < s.length() && s.charAt(i + 1) == '(') {
				// 숫자 뒤에 바로 '('가 오면 스택에 현재 길이를 저장하고, 곱할 숫자를 저장
				stack.push(nowLen);
				stack.push(ch - '0');
				nowLen = 0; // 새로운 문자열을 위해 길이 초기화
				i++; // '(' 건너뛰기
			} else if (ch == ')') {
				int gophagi = stack.pop();
				int lastLen = stack.pop();
				nowLen = lastLen + gophagi * nowLen;
			} else if (ch != '(') {
				nowLen++; // 일반 문자의 경우 길이를 1 증가
			}
			i++;
		}
		return nowLen;
	}
}
