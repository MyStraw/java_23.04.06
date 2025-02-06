package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _12891_DNA비밀번호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int s = Integer.parseInt(inputs[0]);
		int p = Integer.parseInt(inputs[1]);

		String dna = br.readLine();
		String[] minCounts = br.readLine().split(" ");
		int[] minReq = new int[4];
		for (int i = 0; i < 4; i++) {
			minReq[i] = Integer.parseInt(minCounts[i]);
		}

		int[] currentCounts = new int[4];
		int result = 0;

		for (int i = 0; i < p; i++) {
			char c = dna.charAt(i);
			addCount(currentCounts, c);
		}

		if (isValid(currentCounts, minReq)) {
			result++;
		}

		for (int i = p; i < s; i++) {
			char add = dna.charAt(i);
			char remove = dna.charAt(i - p);
			addCount(currentCounts, add);
			removeCount(currentCounts, remove);

			if (isValid(currentCounts, minReq)) {
				result++;
			}
		}

		System.out.println(result);
	}

	private static void addCount(int[] counts, char c) {
		if (c == 'A')
			counts[0]++;
		else if (c == 'C')
			counts[1]++;
		else if (c == 'G')
			counts[2]++;
		else if (c == 'T')
			counts[3]++;
	}

	private static void removeCount(int[] counts, char c) {
		if (c == 'A')
			counts[0]--;
		else if (c == 'C')
			counts[1]--;
		else if (c == 'G')
			counts[2]--;
		else if (c == 'T')
			counts[3]--;
	}

	private static boolean isValid(int[] current, int[] minReq) {
		for (int i = 0; i < 4; i++) {
			if (current[i] < minReq[i]) {
				return false;
			}
		}
		return true;
	}

}
