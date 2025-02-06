package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3541_상근타워2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] elve = new int[m][2];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			elve[i][0] = Integer.parseInt(st.nextToken());
			elve[i][1] = Integer.parseInt(st.nextToken());
		}

		int minFloor = Integer.MAX_VALUE;

		for (int i = 0; i < m; i++) {
			int u = elve[i][0];
			int d = elve[i][1];

			int left = 0;
			int right = n;
			int bestFloor = Integer.MAX_VALUE;

			while (left <= right) {
				int mid = (left + right) / 2;
				int floor = u * mid - d * (n - mid);

				if (floor > 0) {
					bestFloor = Math.min(bestFloor, floor);
					right = mid - 1; 
				} else {
					left = mid + 1;
				}
			}

			minFloor = Math.min(minFloor, bestFloor);
		}

		System.out.println(minFloor);

	}

}
