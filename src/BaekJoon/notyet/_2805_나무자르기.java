package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken()); 

		long[] trees = new long[N];
		st = new StringTokenizer(br.readLine());
		long maxHeight = 0;

		for (int i = 0; i < N; i++) {
			trees[i] = Long.parseLong(st.nextToken());
			maxHeight = Math.max(maxHeight, trees[i]);
		}

		long left = 0;
		long right = maxHeight;
		long answer = 0;

		while (left <= right) {
			long mid = (left + right) / 2;
			long totalWood = 0;

			for (long tree : trees) {
				if (tree > mid) {
					totalWood += (tree - mid);
				}
			}

			if (totalWood >= M) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(answer);
	}

}
