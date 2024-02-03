package BaekJoon.notyet;

import java.util.Scanner;

public class _1212_8진수2진수3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 8진수 입력 받기
		String octal = sc.nextLine();

		// 결과를 저장할 StringBuilder
		StringBuilder binary = new StringBuilder();

		// 8진수 각 자리를 순회하면서 2진수로 변환
		for (int i = 0; i < octal.length(); i++) {
			int digit = Character.digit(octal.charAt(i), 10);
			String binaryDigit = Integer.toBinaryString(digit);

			// 앞쪽 0을 채워 3자리로 만들기 (첫 번째 숫자 제외)
			if (i > 0 && binaryDigit.length() < 3) {
				binary.append("0".repeat(3 - binaryDigit.length()));
			}

			binary.append(binaryDigit);
		}

		// 맨 앞이 0으로 시작하면 제거
		while (binary.length() > 1 && binary.charAt(0) == '0') {
			binary.deleteCharAt(0);
		}

		// 결과 출력
		System.out.println(binary.toString());

	}
}
