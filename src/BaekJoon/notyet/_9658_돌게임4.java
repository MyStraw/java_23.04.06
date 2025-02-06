package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9658_돌게임4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if (n == 1) {
			System.out.println("CY");
			return;
		}

		boolean[] dp = new boolean[Math.max(5, n + 1)];

		dp[2] = true;
		dp[4] = true;

		for (int i = 5; i <= n; i++) {
			if (!dp[i - 1] || !dp[i - 3] || !dp[i - 4]) {
				dp[i] = true;
			}
		}

		System.out.println(dp[n] ? "SK" : "CY");
	}
}
