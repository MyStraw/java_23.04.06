package _백준대회.디미고챌린지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B번 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int V0 = Integer.parseInt(st.nextToken());
		int P0 = Integer.parseInt(st.nextToken());
		int S0 = Integer.parseInt(st.nextToken());

		int JaeWonSum = V0 + P0 + S0;

		List<Status> student = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());

			int sum = V + P + S;

			if (sum <= JaeWonSum) {
				student.add(new Status(V, P, S, sum, i));
			}
		}
		Collections.sort(student, Collections.reverseOrder());
		
		List<Integer> team = new ArrayList<>();
		team.add(0);
		for (int i = 0; i < student.size() && team.size() < M; i++) {
			team.add(student.get(i).Number);
		}

		for (int member : team) {
			System.out.print(member + " ");
		}

	}

	static class Status implements Comparable<Status> {
		int V;
		int P;
		int S;
		int sum;
		int Number;

		Status(int V, int P, int S, int sum, int Number) {
			this.V = V;
			this.P = P;
			this.S = S;
			this.sum = sum;
			this.Number = Number;
		}

		@Override
		public int compareTo(Status o) {
			return Integer.compare(this.sum, o.sum);
		}
	}

}
