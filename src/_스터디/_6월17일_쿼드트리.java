package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6월17일_쿼드트리 {

	public static StringBuilder sb = new StringBuilder();
	public static int[][] Quad;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

//		boolean cham = false;

		Quad = new int[N][N];

		for (int i = 0; i < N; i++) {
			String S = br.readLine();
			for (int j = 0; j < N; j++) {
				Quad[i][j] = S.charAt(j) - '0';
			}
		}

		tree(0, 0, N);		
	}

	static void tree(int x, int y,  int N ) {

		if (cham(x, y, N)) {
			System.out.print(Quad[x][y]);
			return;
		}

		int size = N / 2;

		System.out.print("(");

		tree(x, y, size);
		tree(x, y + size, size);
		tree(x + size, y, size);
		tree(x + size, y + size, size);

		System.out.print(")");
	}

	static boolean cham(int x, int y, int N) {
		int bool = Quad[x][y];

		for (int i = x; i < x + N; i++) {
			for (int j = y; j < y + N; j++) {
				if (bool != Quad[i][j]) {
					return false;
				}
			}
		}
		return true;

	}

}
