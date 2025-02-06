package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _30647_점수관리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Participant> participants = new ArrayList<>();

		br.readLine(); // [
		for (int i = 0; i < N; i++) {
			String line = br.readLine().trim();
			if (i == N - 1) {
				line = line.substring(0, line.length() - 1); // Remove ]
			}
			if (line.endsWith(",")) {
				line = line.substring(0, line.length() - 1); // Remove trailing comma
			}

			line = line.substring(1, line.length() - 1); // Remove { }
			String[] parts = line.split(",");
			String name = parts[0].split(":")[1].replaceAll("\"", "");
			int score = Integer.parseInt(parts[1].split(":")[1]);
			boolean isHidden = Integer.parseInt(parts[2].split(":")[1]) == 1;

			participants.add(new Participant(name, score, isHidden));
		}

		Collections.sort(participants);

		int rank = 0;
		int prevScore = -1;
		int count = 0;

		for (Participant p : participants) {
			if (p.isHidden)
				continue;

			count++;
			if (p.score != prevScore) {
				rank = count;
			}
			prevScore = p.score;

			System.out.println(rank + " " + p.name + " " + p.score);
		}
	}

	static class Participant implements Comparable<Participant> {
		String name;
		int score;
		boolean isHidden;

		Participant(String name, int score, boolean isHidden) {
			this.name = name;
			this.score = score;
			this.isHidden = isHidden;
		}

		@Override
		public int compareTo(Participant other) {
			if (this.score != other.score) {
				return Integer.compare(other.score, this.score);
			}
			return this.name.compareTo(other.name);
		}
	}

}
