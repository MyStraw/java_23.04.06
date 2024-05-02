package BaekJoon.notyet;

import java.util.Scanner;

public class _5300_Fill_the_Rowboats {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++) {
			sb.append(i).append(" ");

			if (i % 6 == 0) {
				sb.append("Go! ");

			}
		}

		if (N % 6 != 0) {
			sb.append("Go!");
		}

		System.out.println(sb.toString().trim());
	}
}
