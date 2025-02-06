package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5544_리그 {
	static class Team implements Comparable<Team> {
		int id;
		int points;

		Team(int id) {
			this.id = id;
			this.points = 0;
		}

		@Override
		public int compareTo(Team other) {
			return other.points - this.points;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		Team[] teams = new Team[N + 1];

		for (int i = 1; i <= N; i++) {
			teams[i] = new Team(i);
		}

		for (int i = 0; i < N * (N - 1) / 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int teamA = Integer.parseInt(st.nextToken());
			int teamB = Integer.parseInt(st.nextToken());
			int scoreA = Integer.parseInt(st.nextToken());
			int scoreB = Integer.parseInt(st.nextToken());

			if (scoreA > scoreB) {
				teams[teamA].points += 3;
			} else if (scoreA < scoreB) {
				teams[teamB].points += 3;
			} else {
				teams[teamA].points += 1;
				teams[teamB].points += 1;
			}
		}

		Arrays.sort(teams, 1, N + 1);

		int[] rank = new int[N + 1];
		int currentRank = 1;

		for (int i = 1; i <= N; i++) {
			if (i > 1 && teams[i].points == teams[i - 1].points) {
				rank[teams[i].id] = rank[teams[i - 1].id];
			} else {
				rank[teams[i].id] = currentRank;
			}
			currentRank++;
		}

		for (int i = 1; i <= N; i++) {
			bw.write(rank[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();

	}

}
