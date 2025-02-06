package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15912_우주선만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] W = new int[N];
		int[] E = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			W[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			E[i] = Integer.parseInt(st.nextToken());
		}

		long[] dp = new long[N + 1];
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i <= N; i++) {
			int maxW = 0;
			int maxE = 0;
			for (int j = i - 1; j >= 0; j--) {
				maxW = Math.max(maxW, W[j]);
				maxE = Math.max(maxE, E[j]);
				dp[i] = Math.min(dp[i], dp[j] + (long) maxW * maxE);
			}
		}

		System.out.println(dp[N]);
	}

}
