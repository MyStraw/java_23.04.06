package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _21650_러시아어 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] scores = new int[n];
		int maxScore = 0;
		for (int i = 0; i < n; i++) {
			scores[i] = Integer.parseInt(st.nextToken());
			maxScore = Math.max(maxScore, scores[i]);
		}

		int bestRank = Integer.MAX_VALUE;
		int maxScoreBefore = 0;

		for (int i = 0; i < n - 1; i++) {
			maxScoreBefore = Math.max(maxScoreBefore, scores[i]);

			if (maxScoreBefore != maxScore || scores[i] % 10 != 5 || scores[i + 1] >= scores[i]) {
				continue;
			}

			int currentRank = 1;
			for (int j = 0; j < n; j++) {
				if (scores[j] > scores[i]) {
					currentRank++;
					if (currentRank >= bestRank) {
						break;
					}
				}
			}

			bestRank = Math.min(bestRank, currentRank);

			if (bestRank == 1) {
				break;
			}
		}

		System.out.println(bestRank == Integer.MAX_VALUE ? 0 : bestRank);
	}
}
