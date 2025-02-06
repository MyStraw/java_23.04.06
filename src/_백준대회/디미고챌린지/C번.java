package _백준대회.디미고챌린지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C번 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] A = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
		}

		int minCount = 0;

		for (int i = 0; i < N / 2; i++) {
			int left = A[i];
			int right = A[N - 1 - i];

			if (left != right) {
				int diff = Math.abs(left - right);

				int count = diff / K;
				diff %= K;
				count += diff;

				minCount += count;
			}
		}

		System.out.println(minCount);
	}

}
