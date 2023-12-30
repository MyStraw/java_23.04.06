package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7568_덩치2 {

	static class Body {
		private int weight;
		private int height;

		public Body(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}

		public boolean isBiggerThan(Body other) {
			return this.weight > other.weight && this.height > other.height;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Body[] big = new Body[N];
		int[] rank = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			big[i] = new Body(weight, height);
			rank[i] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j && big[i].isBiggerThan(big[j])) {
					rank[j]++;
				}
			}
		}

		for (int ranking : rank) {
			System.out.print(ranking + " ");
		}
	}
}
