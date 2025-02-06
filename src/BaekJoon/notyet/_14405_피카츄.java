package BaekJoon.notyet;

import java.util.Scanner;

public class _14405_피카츄 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();

		if (pikachu(S)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	public static boolean pikachu(String S) {

		String[] canSpeak = { "pi", "ka", "chu" };

		int idx = 0;

		while (idx < S.length()) {
			boolean match = false;

			for (String can : canSpeak) {
				if (S.startsWith(can, idx)) {
					idx += can.length();
					match = true;
					break;
				}
			}
			if (!match) {
				return false;
			}

		}
		return true;

	}
}