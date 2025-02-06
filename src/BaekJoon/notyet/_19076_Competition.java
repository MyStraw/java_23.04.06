package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19076_Competition {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] strengths = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			strengths[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			boolean canWin = true;
			for (int j = 0; j < n; j++) {
				if (i != j && Math.abs(strengths[i] - strengths[j]) > K && strengths[i] < strengths[j]) {
					canWin = false;
					break;
				}
			}
			if (canWin) {
				count++;
			}
		}

		System.out.println(count);
	}

}
