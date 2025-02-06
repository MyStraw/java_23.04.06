package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _30971_육회비빔밥2 {
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

		for (int i = 0; i < N; i++) {
			visited[i] = true;
			backtrack(i, 1, 0, C[i]);
			visited[i] = false;
		}

		System.out.println(max);
	}

	public static void backtrack(int current, int depth, int total, int preC) {
		if (depth == N) {
			max = Math.max(max, total);
			return;
		}

		for (int next = 0; next < N; next++) {
			if (!visited[next]) {
				int eyeChi = preC * C[next];
				if (depth > 1 && eyeChi > K) {
					continue;
				}
				visited[next] = true;
				int newGam = total;
				if (depth > 0) {
					newGam += A[current] * B[next];
				}
				backtrack(next, depth + 1, newGam, C[next]);
				visited[next] = false;
			}
		}
	}

}
