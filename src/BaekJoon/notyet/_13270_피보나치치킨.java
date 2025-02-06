package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _13270_피보나치치킨 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Integer> people = new ArrayList<>();
		List<Integer> chicken = new ArrayList<>();
		people.add(2);
		chicken.add(1);
		people.add(3);
		chicken.add(2);

		while (people.get(people.size() - 1) <= N) {
			people.add(people.get(people.size() - 1) + people.get(people.size() - 2));
			chicken.add(chicken.get(chicken.size() - 1) + chicken.get(chicken.size() - 2));
		}

		int[] minDp = new int[N + 1];
		int[] maxDp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			minDp[i] = Integer.MAX_VALUE;
			for (int j = 0; j < people.size(); j++) {
				if (people.get(j) > i)
					break;
				if (minDp[i - people.get(j)] != Integer.MAX_VALUE) {
					minDp[i] = Math.min(minDp[i], minDp[i - people.get(j)] + chicken.get(j));
				}
			}

			for (int j = 0; j < people.size(); j++) {
				if (people.get(j) > i)
					break;
				maxDp[i] = Math.max(maxDp[i], maxDp[i - people.get(j)] + chicken.get(j));
			}
		}

		System.out.println(minDp[N] + " " + maxDp[N]);
	}

}
