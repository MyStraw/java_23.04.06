package BaekJoon.notyet;

import java.util.Scanner;

public class _1439_뒤집기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();

		int count0 = 0;
		int count1 = 0;

		if (S.charAt(0) == '0') {
			count1++;
		} else {
			count0++;
		}

		for (int i = 1; i < S.length(); i++) {
			if (S.charAt(i) != S.charAt(i - 1)) {

				if (S.charAt(i) == '1') {
					count0++;
				} else {
					count1++;
				}
			}
		}

		System.out.println(Math.min(count0, count1));

	}

}
