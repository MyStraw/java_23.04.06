package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class __3985_롤케이크 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int[] cake = new int[L + 1];
		int[] actual = new int[N + 1];
		int maxExpect = 0, maxActual = 0;
		int maxExpectIndex = 0, maxActualIndex = 0;

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int expected = K - P + 1;

			if (expected > maxExpect) {
				maxExpect = expected;
				maxExpectIndex = i;
			}

			for (int j = P; j <= K; j++) {
				if (cake[j] == 0) {
					cake[j] = i;
					actual[i]++;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (actual[i] > maxActual) {
				maxActual = actual[i];
				maxActualIndex = i;
			}
		}

		System.out.println(maxExpectIndex);
		System.out.println(maxActualIndex);
	}

}
