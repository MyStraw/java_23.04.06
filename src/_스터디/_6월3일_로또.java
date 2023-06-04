package _스터디;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _6월3일_로또 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());

			if (k == 0) {
				bw.flush(); // 이거 위치가 어려웠다. 이거 위치는 현진이가 갈켜줌.
				return;
			}
			int[] S = new int[k];
			int[] lotto = new int[6];
			for (int i = 0; i < k; i++) {
				int s = Integer.parseInt(st.nextToken());
				S[i] = s;
			}
			// k와 집합 S 주어졌다. 여기까진 기본

			lottong(k, S, lotto);
			bw.write("\n");
		}
	}

	private static void lottong(int k, int[] S, int[] lotto) throws IOException {
		for (int a = 0; a < k - 5; a++) {
			lotto[0] = S[a];
			for (int b = a + 1; b < k - 4; b++) {
				lotto[1] = S[b];
				for (int c = b + 1; c < k - 3; c++) {
					lotto[2] = S[c];
					for (int d = c + 1; d < k - 2; d++) {
						lotto[3] = S[d];
						for (int e = d + 1; e < k - 1; e++) {
							lotto[4] = S[e];
							for (int f = e + 1; f < k; f++) {
								lotto[5] = S[f];
								
								
								
								
								
								for (int i = 0; i < 6; i++) {
									bw.write(lotto[i] + " ");
								}
								bw.write("\n");
							}
						}
					}
				}
			}
		}
	}
}
