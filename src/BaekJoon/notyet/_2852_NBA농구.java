package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2852_NBA농구 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] score = new int[2];
		int prevTime = 0;
		int team1Time = 0;
		int team2Time = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int team = Integer.parseInt(st.nextToken()) - 1;
			String[] timeStr = st.nextToken().split(":");
			int time = Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]);

			if (i > 0) {
				if (score[0] > score[1]) {
					team1Time += time - prevTime;
				} else if (score[1] > score[0]) {
					team2Time += time - prevTime;
				}
			}

			score[team]++;
			prevTime = time;
		}

		int finalTime = 48 * 60;
		if (score[0] > score[1]) {
			team1Time += finalTime - prevTime;
		} else if (score[1] > score[0]) {
			team2Time += finalTime - prevTime;
		}

		System.out.printf("%02d:%02d\n", team1Time / 60, team1Time % 60);
		System.out.printf("%02d:%02d\n", team2Time / 60, team2Time % 60);
	}

}
