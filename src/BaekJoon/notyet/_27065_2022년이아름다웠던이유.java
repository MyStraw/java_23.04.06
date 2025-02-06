package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _27065_2022년이아름다웠던이유 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());

			int sum = 0;
			for (int i = 1; i <= n / 2; i++) {
				if (n % i == 0) {
					sum += i;
				}
			}

			boolean over = sum > n;

			boolean all = true;
			for (int i = 1; i <= n / 2; i++) {
				if (n % i == 0) {
					int divSum = 0;
					for (int j = 1; j <= i / 2; j++) {
						if (i % j == 0) {
							divSum += j;
						}
					}
					if (divSum > i) {
						all = false;
						break;
					}
				}
			}

			if (over && all) {
				sb.append("Good Bye\n");
			} else {
				sb.append("BOJ 2022\n");
			}
		}

		System.out.print(sb.toString());
	}

}
