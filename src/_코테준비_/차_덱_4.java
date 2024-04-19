package _코테준비_;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 차_덱_4 {
	public static String makePalindrome(String s) {
		Map<Character, Integer> charCounts = new HashMap<>();
		for (char c : s.toCharArray()) {
			charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
		}

		Deque<Character> deque = new LinkedList<>();
		Character mid = null;
		for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
			char c = entry.getKey();
			int count = entry.getValue();

			if (count % 2 == 1) {
				if (mid != null)
					return "팰린드롬 불가능"; // 두 개 이상의 홀수 카운트를 가진 문자가 있으면 팰린드롬 불가
				mid = c;
			}

			for (int i = 0; i < count / 2; i++) {
				deque.addFirst(c);
				deque.addLast(c);
			}
		}

		if (mid != null)
			deque.addLast(mid); // 중간에 홀수 카운트 문자 추가

		StringBuilder sb = new StringBuilder();
		while (!deque.isEmpty()) {
			sb.append(deque.pollFirst());
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "aabb";
		System.out.println("만들 수 있는 팰린드롬: " + makePalindrome(s));
	}

}

//문자열 "aabb"
//출력 예시:
//
//"abba"
