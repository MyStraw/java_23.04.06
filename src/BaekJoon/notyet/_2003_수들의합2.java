package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2003_수들의합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;
		int sum = 0;
		int start = 0;
		int end = 0;

		while (true) {
			if (sum >= M) {
				sum -= A[start++];
			} else if (end == N) {
				break;
			} else {
				sum += A[end++];
			}
			if (sum == M) {
				count++;
			}
		}
		System.out.println(count);
	}

}
