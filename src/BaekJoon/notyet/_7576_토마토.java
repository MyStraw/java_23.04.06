package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _7576_토마토 {
	static int M, N;
	static int[][] box;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Queue<Tomato> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] dims = br.readLine().split(" ");
		M = Integer.parseInt(dims[0]);
		N = Integer.parseInt(dims[1]);

		box = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] row = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(row[j]);
				if (box[i][j] == 1) {
					queue.add(new Tomato(i, j));
				}
			}
		}

		System.out.println(bfs());
	}

	public static int bfs() {
		while (!queue.isEmpty()) {
			Tomato tomato = queue.poll();
			int x = tomato.x;
			int y = tomato.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
					if (box[ny][nx] == 0) {
						box[ny][nx] = box[y][x] + 1;
						queue.add(new Tomato(ny, nx));
					}
				}
			}
		}

		int maxDay = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					return -1;
				}
				maxDay = Math.max(maxDay, box[i][j]);
			}
		}

		return maxDay - 1;
	}

	static class Tomato {
		int x, y;

		public Tomato(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

}
