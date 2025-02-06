package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _29733_3차원지뢰찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		char[][][] mine = new char[H][R][C];

		int[][][] answer = new int[H][R][C];

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < R; r++) {
				String line = br.readLine();
				for (int c = 0; c < C; c++) {
					mine[h][r][c] = line.charAt(c);

					answer[h][r][c] = 0;
				}
			}
		}

		int[] dh = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
		int[] dr = { 1, 1, 1, 0, 0, 0, -1, -1, -1, 1, 1, 1, 0, 0, -1, -1, -1, 1, 1, 1, 0, 0, 0, -1, -1, -1 };
		int[] dc = { 1, 0, -1, 1, 0, -1, 1, 0, -1, 1, 0, -1, 1, -1, 1, 0, -1, 1, 0, -1, 1, 0, -1, 1, 0, -1 };

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (mine[h][r][c] == '*') {
						answer[h][r][c] = -1;
						continue;
					}
					for (int k = 0; k < 26; k++) {
						int nh = h + dh[k];
						int nr = r + dr[k];
						int nc = c + dc[k];

						if (nh < 0 || nh >= H || nr < 0 || nr >= R || nc < 0 || nc >= C) {
							continue;
						}
						if (mine[nh][nr][nc] == '*') {
							answer[h][r][c]++;
						}
					}
					answer[h][r][c] = answer[h][r][c] % 10;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (answer[h][r][c] == -1) {
						sb.append('*');
					} else {
						sb.append(answer[h][r][c]);
					}
				}
				sb.append("\n");
			}
		}

		System.out.print(sb.toString());
	}

}
