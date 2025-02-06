package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4108_지뢰찾기 {
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String[] input = br.readLine().split(" ");
			int R = Integer.parseInt(input[0]);
			int C = Integer.parseInt(input[1]);

			if (R == 0 && C == 0)
				break;

			char[][] grid = new char[R][C];

			for (int i = 0; i < R; i++) {
				grid[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (grid[i][j] == '*') {
						sb.append('*');
					} else {
						int count = 0;
						for (int d = 0; d < 8; d++) {
							int ni = i + dx[d];
							int nj = j + dy[d];
							if (ni >= 0 && ni < R && nj >= 0 && nj < C && grid[ni][nj] == '*') {
								count++;
							}
						}
						sb.append(count);
					}
				}
				sb.append('\n');
			}
		}
		System.out.print(sb);
	}

}
