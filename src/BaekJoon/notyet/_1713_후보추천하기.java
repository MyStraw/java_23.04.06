package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class _1713_후보추천하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int total = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		List<Integer> frames = new ArrayList<>();
		Map<Integer, Integer> votes = new HashMap<>();

		for (int i = 0; i < total; i++) {
			int student = Integer.parseInt(st.nextToken());

			if (frames.contains(student)) {
				votes.put(student, votes.get(student) + 1);
			} else {
				if (frames.size() < N) {
					frames.add(student);
					votes.put(student, 1);
				} else {
					int minVotes = Integer.MAX_VALUE;
					int candidate = 0;

					for (int f : frames) {
						if (votes.get(f) < minVotes) {
							minVotes = votes.get(f);
							candidate = f;
						} else if (votes.get(f) == minVotes && frames.indexOf(f) < frames.indexOf(candidate)) {
							candidate = f;
						}
					}

					frames.remove((Integer) candidate);
					votes.remove(candidate);
					frames.add(student);
					votes.put(student, 1);
				}
			}
		}

		Collections.sort(frames);
		StringBuilder sb = new StringBuilder();
		for (int f : frames) {
			sb.append(f).append(" ");
		}
		System.out.println(sb.toString().trim());
	}

}
