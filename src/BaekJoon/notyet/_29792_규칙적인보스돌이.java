package BaekJoon.notyet;

import java.util.Arrays;
import java.util.Scanner;

public class _29792_규칙적인보스돌이 {
	static int N, M, K;
	static long[] dmg;
	static long[][] boss; 
	static long[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();

		dmg = new long[N];
		for (int i = 0; i < N; i++) {
			dmg[i] = sc.nextLong();
		}

		boss = new long[K][2];
		for (int i = 0; i < K; i++) {
			boss[i][0] = sc.nextLong();
			boss[i][1] = sc.nextLong(); 
		}

		dp = new long[N][901];

		for (int i = 0; i < N; i++) {
			solveDP(i);
		}
	
		long[] maxMesoByChar = new long[N];
		for (int i = 0; i < N; i++) {
			maxMesoByChar[i] = dp[i][900];
		}
		Arrays.sort(maxMesoByChar);

		long result = 0;
		for (int i = N - 1; i >= N - M; i--) {
			result += maxMesoByChar[i];
		}

		System.out.println(result);
	}

	static void solveDP(int idx) {
		for (int j = 0; j < K; j++) {
			long time = (boss[j][0] + dmg[idx] - 1) / dmg[idx];
			if (time <= 900) {
				for (int t = 900; t >= time; t--) {
					dp[idx][t] = Math.max(dp[idx][t], dp[idx][(int) (t - time)] + boss[j][1]);
				}
			}
		}
	}

}
