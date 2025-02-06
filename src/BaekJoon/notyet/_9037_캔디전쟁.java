package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9037_캔디전쟁 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] candies = new int[N];

			String[] inputs = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				candies[i] = Integer.parseInt(inputs[i]);
				if (candies[i] % 2 != 0) {
					candies[i]++;
				}
			}

			int rounds = 0;
			while (!allEqual(candies)) {
				int[] halfCandies = new int[N];

				for (int i = 0; i < N; i++) {
					halfCandies[i] = candies[i] / 2;
				}

				for (int i = 0; i < N; i++) {
					candies[i] = candies[i] / 2 + halfCandies[(i - 1 + N) % N];
					if (candies[i] % 2 != 0) {
						candies[i]++;
					}
				}

				rounds++;
			}

			System.out.println(rounds);
		}
	}

	private static boolean allEqual(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[0]) {
				return false;
			}
		}
		return true;
	}
}
