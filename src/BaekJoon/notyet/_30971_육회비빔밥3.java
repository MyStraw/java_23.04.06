package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _30971_육회비빔밥3 {
	static int N, K;
	static int[] A, B, C;
	static boolean[] visited;
	static int max = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N];
		B = new int[N];
		C = new int[N];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			C[i] = Integer.parseInt(st.nextToken());
		}

		backtrack(0, 0, -1, -1);

		System.out.println(max);
	}

	static void backtrack(int count, int gamChil, int preTaste, int preEyeChi) {
		if (count == N) {
			max = Math.max(max, gamChil);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;

				if (count == 0) {
					backtrack(count + 1, gamChil, A[i], C[i]);
				} else {
					int newGamchil = gamChil + (preTaste * B[i]);
					int newEyeChi = preEyeChi * C[i];
					if (newEyeChi <= K) {
						backtrack(count + 1, newGamchil, A[i], C[i]);
					}
				}

				visited[i] = false;
			}
		}
	}

}
