package BaekJoon.notyet;

import java.util.Scanner;

public class _1662_압축4 { // gpt 이용했음. StringBuilder은 쓸수없겠다. 그냥 String을 바로 쓰면 됨. 재귀 쓰기.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();

		System.out.println(alzip(S));
	}

	private static int alzip(String s) {
		int totalLength = 0;
		int currentMultiplier = 0;
		int nestedMultiplier = 1;
		int i = 0;

		while (i < s.length()) {
			if (Character.isDigit(s.charAt(i)) && i + 1 < s.length() && s.charAt(i + 1) == '(') {
				// 숫자를 읽고 괄호 내부로 진입
				currentMultiplier = s.charAt(i) - '0';
				i += 2; // '(' 넘기기
				int subLength = 0;
				int depth = 1; // 괄호 깊이
				int start = i;

				while (depth > 0) {
					if (s.charAt(i) == '(')
						depth++;
					else if (s.charAt(i) == ')')
						depth--;
					if (depth > 0)
						i++;
				}

				subLength = alzip(s.substring(start, i));
				totalLength += subLength * currentMultiplier;
			} else if (s.charAt(i) != '(' && s.charAt(i) != ')') {
				// 일반 문자는 길이 증가
				totalLength += nestedMultiplier;
			}
			i++;
		}

		return totalLength;
	}
}
