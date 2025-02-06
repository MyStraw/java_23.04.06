package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2737_연속합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			long N = Long.parseLong(br.readLine());
			int count = 0;

			for (long j = 2; j * (j - 1) / 2 < N; j++) {
				long bunja = N - j * (j - 1) / 2;
				if (bunja % j == 0) {
					count++;
				}
			}

			System.out.println(count);
		}
	}

}
