package BaekJoon.notyet;

import java.util.Scanner;

public class _27919_UDPC파티2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String V = sc.next();

		int ucCount = 0;
		int dpCount = 0;

		for (int i = 0; i < V.length(); i++) {
			if (V.charAt(i) == 'U' || V.charAt(i) == 'C') {
				ucCount++;
			}
			if (V.charAt(i) == 'D' || V.charAt(i) == 'P') {
				dpCount++;
			}
		}

		StringBuilder sb = new StringBuilder();

		if ((dpCount + 1) / 2 < ucCount) {
			sb.append("U");
		}

		if (dpCount != 0) {
			sb.append("DP");
		}

		System.out.println(sb.toString());

	}
}
