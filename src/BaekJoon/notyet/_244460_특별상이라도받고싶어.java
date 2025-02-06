package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _244460_특별상이라도받고싶어 {

	static int[][] board;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(solve(0, 0, N));
	}

	static int solve(int x, int y, int size) {
		if (size == 1) {
			return board[x][y];
		}

		int newSize = size / 2;
		int[] candidates = new int[4];
		candidates[0] = solve(x, y, newSize);
		candidates[1] = solve(x, y + newSize, newSize);
		candidates[2] = solve(x + newSize, y, newSize);
		candidates[3] = solve(x + newSize, y + newSize, newSize);

		Arrays.sort(candidates);
		return candidates[1]; 
	}

}
