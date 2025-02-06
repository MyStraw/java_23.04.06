package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2830_행성x3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] residents = new int[N];

		for (int i = 0; i < N; i++) {
			residents[i] = Integer.parseInt(br.readLine());
		}

		long totalValue = 0;

		for (int bit = 0; bit < 30; bit++) {
			long countOne = 0;
			
			for (int i = 0; i < N; i++) {
				if ((residents[i] & (1 << bit)) != 0) {
					countOne++;
				}
			}
			
			long countZero = N - countOne;
			
			totalValue += countOne * countZero * (1 << bit);
		}

		System.out.println(totalValue);
	}

}
