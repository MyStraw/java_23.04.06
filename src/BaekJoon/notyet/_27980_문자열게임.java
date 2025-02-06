package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _27980_문자열게임 {
	static int N, M, ans;
	static int[][] dp;
	static String board, word;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);

		board = br.readLine();
		word = br.readLine();

		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, dfs(i, 0));
		}

		System.out.println(ans);
	}

	private static int dfs(int idx1, int idx2) {
		if (idx2 == M)
			return 0;

		if (dp[idx1][idx2] != -1)
			return dp[idx1][idx2];

		int point = 0;

		if (idx1 > 0) {
			point = Math.max(point, dfs(idx1 - 1, idx2 + 1));
		}

		if (idx1 < N - 1) {
			point = Math.max(point, dfs(idx1 + 1, idx2 + 1));
		}

		if (board.charAt(idx1) == word.charAt(idx2)) {
			point++;
		}

		return dp[idx1][idx2] = point;
	}

}
