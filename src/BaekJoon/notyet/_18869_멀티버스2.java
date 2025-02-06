package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _18869_멀티버스2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] universe = new int[n];
		int[][] japyo = new int[m][n];
		int total = 0;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				universe[j] = Integer.parseInt(st.nextToken());
			}

			int[] sort = Arrays.stream(universe).distinct().sorted().toArray();
			for (int j = 0; j < n; j++) {
				japyo[i][j] = Arrays.binarySearch(sort, universe[j]);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = i + 1; j < m; j++) {
				if (Arrays.equals(japyo[i], japyo[j])) {
					total++;
				}
			}
		}

		System.out.println(total);
	}
}
