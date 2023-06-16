package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6월17일_쿼드트리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		char[][] Quad = new char[N][N];

		boolean cham = false;

		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			for (int j = 0; j < N; j++) {
				Quad[i][j] = S.charAt(j);
			}
		}

		tree(Quad, false, N, 0, 0);
	}

	static void tree(char[][] Quad, boolean cham, int N, int x, int y) {

		if (N == 1) {
			if (Quad[x][y] == 1) {
				cham = true;
			} else
				cham = false;
		}

		int size = N / 2;
		int count = 0;

		for (int i = x; i < x + N; size++) {
			for (int j = y; j < y + N; size++) {
				count++;
				if (count == 4) {
					tree(Quad, true, size, i, j);
				} else {
					tree(Quad, false, size, i, j);
				}

			}
		}
	}

}
