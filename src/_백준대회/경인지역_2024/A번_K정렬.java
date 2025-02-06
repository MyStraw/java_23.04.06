package _백준대회.경인지역_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A번_K정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] firstLine = br.readLine().split(" ");
		int N = Integer.parseInt(firstLine[0]);
		int K = Integer.parseInt(firstLine[1]);

		String[] secondLine = br.readLine().split(" ");
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(secondLine[i]);
		}

		if (canSort(N, K, A)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static boolean canSort(int N, int K, int[] A) {
		List<List<Integer>> groups = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			groups.add(new ArrayList<>());
		}

		for (int i = 0; i < N; i++) {
			groups.get(i % K).add(A[i]);
		}

		for (List<Integer> group : groups) {
			Collections.sort(group);
		}

		int[] sortedA = new int[N];
		int[] indices = new int[K];

		for (int i = 0; i < N; i++) {
			sortedA[i] = groups.get(i % K).get(indices[i % K]++);
		}

		for (int i = 1; i < N; i++) {
			if (sortedA[i - 1] > sortedA[i]) {
				return false;
			}
		}

		return true;
	}

}
