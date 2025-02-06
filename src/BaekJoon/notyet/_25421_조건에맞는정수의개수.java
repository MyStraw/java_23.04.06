package BaekJoon.notyet;

import java.util.Scanner;

public class _25421_조건에맞는정수의개수 {
	static final int MOD = 987654321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		if (n == 1) {
			System.out.println(9);
			return;
		}

		long[][] dp = new long[n + 1][10];

		
		for (int j = 1; j <= 9; j++) {
			dp[1][j] = 1;
		}

	
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= 9; j++) {
				dp[i][j] = 0;
				for (int k = Math.max(1, j - 2); k <= Math.min(9, j + 2); k++) {
					dp[i][j] = (dp[i][j] + dp[i - 1][k]) % MOD;
				}
			}
		}

	
		long result = 0;
		for (int j = 1; j <= 9; j++) {
			result = (result + dp[n][j]) % MOD;
		}

		System.out.println(result);
	}

}
