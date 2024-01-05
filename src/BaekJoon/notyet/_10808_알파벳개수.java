package BaekJoon.notyet;

import java.util.Scanner;

public class _10808_알파벳개수 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] alphabetCount = new int[26]; // 알파벳 개수를 저장할 배열

        // 각 알파벳의 출현 횟수를 계산
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            alphabetCount[currentChar - 'a']++;
        }

        // 결과 출력
        for (int count : alphabetCount) {
            System.out.print(count + " ");
        }
        System.out.println();
    }

}
