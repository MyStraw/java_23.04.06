package BaekJoon.notyet;

import java.util.Scanner;

public class _11727_2xn타일링2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	

		System.out.println(solve(n));
	}

	public static int solve(int n) {
		if (n <= 2)
			return n == 1 ? 1 : 3;

		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 3;

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
		}

		return dp[n];
	}

}
