package _코테준비_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 문자열_3 {
	public static String separateAndSort(String s) {
		List<Character> letters = new ArrayList<>();
		List<Character> numbers = new ArrayList<>();
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				numbers.add(c);
			} else {
				letters.add(c);
			}
		}
		Collections.sort(letters);
		Collections.sort(numbers);
		StringBuilder result = new StringBuilder();
		for (Character c : letters)
			result.append(c);
		for (Character c : numbers)
			result.append(c);
		return result.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자열을 입력하세요: ");
		String input = scanner.nextLine();
		System.out.println("정렬된 문자열: " + separateAndSort(input));
	}

}
//
//상: 문자열에서 숫자와 문자 분리
//
//문제: 주어진 문자열에서 숫자와 문자를 분리하여, 숫자는 오름차순으로 정렬하고 문자는 알파벳 순으로 정렬하여 반환하라.


//입력 예시
//Copy code
//a1b2c3d4
//출력 예시
//Copy code
//abcd1234