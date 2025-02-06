package _백준대회.디미고챌린지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D번 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] dp = new long[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			long maxHappiness = 0;

			for (int j = 0; j < l; j++) {
				int p = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				maxHappiness = Math.max(maxHappiness, dp[p - 1] + v);
				dp[p] = Math.max(dp[p], maxHappiness);
			}

			for (int j = 1; j <= N; j++) {
				dp[j] = Math.max(dp[j], dp[j - 1]);
			}
		}

		System.out.println(dp[N]);
	}

}
