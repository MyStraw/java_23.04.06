package BaekJoon.notyet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _1316_그룹단어체커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 단어의 개수 입력받기
		int groupWordCount = 0; // 그룹 단어의 개수

		for (int i = 0; i < N; i++) {
			String word = sc.next(); // 단어 입력받기
			if (isGroupWord(word)) {
				groupWordCount++; // 그룹 단어라면 카운트 증가
			}
		}

		System.out.println(groupWordCount); // 그룹 단어의 개수 출력
	}

	// 그룹 단어인지 판별하는 함수
	private static boolean isGroupWord(String word) {
		Set<Character> seenChars = new HashSet<>(); // 이미 본 문자 저장
		char lastChar = ' '; // 이전 문자

		for (char currentChar : word.toCharArray()) {
			if (lastChar != currentChar) { // 이전 문자와 현재 문자가 다른 경우
				if (seenChars.contains(currentChar)) {
					return false; // 이미 본 문자라면 그룹 단어가 아님
				}
				seenChars.add(currentChar); // 현재 문자 저장
				lastChar = currentChar; // 이전 문자 업데이트
			}
		}

		return true; // 그룹 단어임
	}

}
