package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11047_동전0_1 { // 재귀
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] won = new int[N];

		for (int i = 0; i < N; i++) {
			won[i] = Integer.parseInt(br.readLine());
		}
		int count = coin(won, N - 1, K);
		System.out.println(count);
	}

	private static int coin(int[] won, int N, int K) {
		if (K == 0) {
			return 0;
		}

		int count = K / won[N];
		K %= won[N];

		if (N == 0) {
			return count;
		} else {
			return count + coin(won, N - 1, K);
		}
	}
}
