package BaekJoon.notyet;

import java.util.Scanner;

public class _11283_한글2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char han = sc.next().charAt(0);

		int result = getIndex(han);
		System.out.println(result);

	}

	public static int getIndex(char han) {
		int uniCode = 0xAC00; // "가"의 유니코드
		int code = han - uniCode;

		int jongIdx = code % 28;
		int jungIdx = (code / 28) % 21;
		int choIdx = (code / 28) / 21;

		return choIdx * 21 * 28 + jungIdx * 28 + jongIdx + 1;
	}

}
