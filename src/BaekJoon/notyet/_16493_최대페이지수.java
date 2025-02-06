package BaekJoon.notyet;

import java.util.Scanner;

public class _16493_최대페이지수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] day = new int[M];
		int[] page = new int[M];

		for (int i = 0; i < M; i++) {
			day[i] = sc.nextInt();
			page[i] = sc.nextInt();
		}

		int[] dp = new int[N + 1];

		for (int i = 0; i < M; i++) {
			for (int j = N; j >= day[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - day[i]] + page[i]);
			}
		}

		System.out.println(dp[N]);

	}

}
