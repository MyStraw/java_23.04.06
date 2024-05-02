package BaekJoon.notyet;

import java.util.Scanner;

public class _5357_Dedupe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			String str = sc.next();
			StringBuilder sb = new StringBuilder();

			sb.append(str.charAt(0));

			for (int j = 1; j < str.length(); j++) {
				if (str.charAt(j) != str.charAt(j - 1)) {
					sb.append(str.charAt(j));
				}
			}
			System.out.println(sb.toString());

		}

	}

}
