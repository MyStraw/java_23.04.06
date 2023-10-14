package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2738_행렬덧셈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer stst;

		int h = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] hang = new int[h][r];
		int[][] hang2 = new int[h][r];
		int[][] hap = new int[h][r];

		for (int i = 0; i < h; i++) {
			stst = new StringTokenizer(br.readLine());
			for (int j = 0; j < h; j++) {
				for (int k = 0; k < r; k++) {
					hang[j][k] = Integer.parseInt(stst.nextToken());
				}
			}
		}

	}

}
