package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24426_알고리즘수업_행렬경로문제3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][][] dp = new long[N + 1][N + 1][3];
		long[][] arr = new long[N + 1][N + 1];

		for (int i = 2; i <= N; i++) {
			arr[i][0] = arr[0][i] = -1000000007;
		}

		for (int r = 1; r <= N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c = 1; c <= N; c++) {
				arr[r][c] = Long.parseLong(st.nextToken());
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		for (int r = 0; r <= N; r++) {
			for (int c = 0; c <= N; c++) {
				if (r > 0 && c > 0) {
					dp[r][c][0] = arr[r][c] + Math.max(dp[r - 1][c][0], dp[r][c - 1][0]);
					if (r == R && c == C) {
						dp[r][c][1] = arr[r][c] + Math.max(dp[r - 1][c][0], dp[r][c - 1][0]);
						dp[r][c][2] = -1000000007;
					} else {
						if (Math.max(dp[r - 1][c][1], dp[r][c - 1][1]) > 0)
							dp[r][c][1] = arr[r][c] + Math.max(dp[r - 1][c][1], dp[r][c - 1][1]);
						dp[r][c][2] = arr[r][c] + Math.max(dp[r - 1][c][2], dp[r][c - 1][2]);
					}
				} else if (r > 0) {
					dp[r][c][0] = arr[r][c] + dp[r - 1][c][0];
					if (dp[r - 1][c][1] > 0)
						dp[r][c][1] = arr[r][c] + dp[r - 1][c][1];
					dp[r][c][2] = arr[r][c] + dp[r - 1][c][2];
				} else if (c > 0) {
					dp[r][c][0] = arr[r][c] + dp[r][c - 1][0];
					if (dp[r][c - 1][1] > 0)
						dp[r][c][1] = arr[r][c] + dp[r][c - 1][1];
					dp[r][c][2] = arr[r][c] + dp[r][c - 1][2];
				}
			}
		}

		System.out.println(dp[N][N][1] + " " + dp[N][N][2]);
	}

}
