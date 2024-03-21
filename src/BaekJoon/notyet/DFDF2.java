package BaekJoon.notyet;

import java.util.ArrayList;
import java.util.List;

public class DFDF2 {
	private static final String key = "TSFHHABP";
	private static final String hint = "\\BD_OBNZ";
	private static long counter = 0; // 처리된 문자열 수를 추적하는 전역 변수
	private static List<String> validInputs = new ArrayList<>(); // 유효한 입력을 저장하는 리스트

	public static void main(String[] args) {
		char[] str = new char[8];
		bruteForce(0, str);
		System.out.println("Found valid inputs:");
		for (String validInput : validInputs) {
			System.out.println(validInput);
		}
	}

	private static void bruteForce(int position, char[] str) {
		if (position == 8) {
			counter++; // 문자열을 하나 처리할 때마다 카운터 증가
			if (counter % 1000000000 == 0) { // 1억 개마다 진행 상태 출력
				double progress = (double) counter / 208827064576L * 100; // 백분율 계산
				System.out.printf("%d/%d (%.2f%%)\n", counter, 208827064576L, progress);
			}
			if (validateInput2(new String(str))) {
				validInputs.add(new String(str));
				//System.exit(0); // 조건을 만족하는 입력을 찾으면 프로그램 종료
			}
			return;
		}

		for (char c = 'A'; c <= 'Z'; c++) {
			str[position] = c;
			bruteForce(position + 1, str);
		}
	}

	private static boolean validateInput2(String str) {
		int prv = 0;
		for (int i = 0; i < 8; i++) {
			prv = ((prv << 1) ^ str.charAt(i)) & 31;
			if (prv + 'A' != key.charAt(i))
				return false;
		}
		return true;
	}

}
