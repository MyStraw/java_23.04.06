package _코테준비_;

import java.util.Scanner;
import java.util.Stack;

public class 문자열_4 {
	public static String decompress(String s) {
		Stack<Integer> countStack = new Stack<>();
		Stack<StringBuilder> stringStack = new Stack<>();
		StringBuilder current = new StringBuilder();
		int k = 0;
		for (char ch : s.toCharArray()) {
			if (Character.isDigit(ch)) {
				k = k * 10 + ch - '0';
			} else if (ch == '[') {
				countStack.push(k);
				stringStack.push(current);
				current = new StringBuilder();
				k = 0;
			} else if (ch == ']') {
				StringBuilder temp = current;
				current = stringStack.pop();
				for (k = countStack.pop(); k > 0; --k)
					current.append(temp);
			} else {
				current.append(ch);
			}
		}
		return current.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("압축된 문자열을 입력하세요: ");
		String compressed = scanner.nextLine();
		System.out.println("압축 해제된 문자열: " + decompress(compressed));
	}

}
//
//최상: 문자열 압축 해제
//
//문제: "3[a2[c]]"와 같이 압축된 문자열이 주어질 때, 압축을 해제한 문자열을 반환하라. 예를 들어, "3[a2[c]]"는 "accaccacc"로 해제된다.

//입력 예시
//css
//Copy code
//3[a2[c]]
//출력 예시
//Copy code
//accaccacc
