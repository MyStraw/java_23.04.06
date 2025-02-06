package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14922_부분평균2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] A = new double[N];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Double.parseDouble(input[i]);
		}

		if (N == 2) {
			System.out.println(0);
			return;
		}

		double minAverage = (A[0] + A[1]) / 2;
		int minIndex = 0;

		for (int i = 2; i < N; i++) {
			double avg3 = (A[i - 2] + A[i - 1] + A[i]) / 3;
			if (avg3 < minAverage) {
				minAverage = avg3;
				minIndex = i - 2;
			}
		}

		for (int i = 1; i < N; i++) {
			double avg2 = (A[i - 1] + A[i]) / 2;
			if (avg2 < minAverage) {
				minAverage = avg2;
				minIndex = i - 1;
			}
		}

		System.out.println(minIndex);
	}

}
