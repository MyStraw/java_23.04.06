package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20152_GameAddiction {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int H = Integer.parseInt(input[0]);
		int W = Integer.parseInt(input[1]);
		
		if (H < W) {
			int temp = H;
			H = W;
			W = temp;
		}

		int diff = H - W + 1;
		long[][] dp = new long[diff][diff];

		for (int i = 0; i < diff; i++) {
			dp[0][i] = 1;
		}

		for (int i = 1; i < diff; i++) {
			for (int j = i; j < diff; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		System.out.println(dp[diff - 1][diff - 1]);
	}

}
