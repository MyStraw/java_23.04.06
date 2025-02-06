package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14922_부분평균 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] A = new long[N];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(input[i]);
		}

		long[] prefixSum = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			prefixSum[i] = prefixSum[i - 1] + A[i - 1];
		}

		double minAvg = Double.MAX_VALUE;
		int minU = 0;

		for (int P = 0; P < N - 1; P++) {
			for (int Q = P + 1; Q < N; Q++) {
				double currentAvg = (double) (prefixSum[Q + 1] - prefixSum[P]) / (Q - P + 1);
				if (currentAvg < minAvg) {
					minAvg = currentAvg;
					minU = P;
				}
			}
		}

		System.out.println(minU);
	}

}
