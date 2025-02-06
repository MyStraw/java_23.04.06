package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _7569_토마토 {

	static int M, N, H;
	static int[][][] box;
	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static Queue<Tomato> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] dims = br.readLine().split(" ");
		M = Integer.parseInt(dims[0]);
		N = Integer.parseInt(dims[1]);
		H = Integer.parseInt(dims[2]);

		box = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				String[] row = br.readLine().split(" ");
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(row[k]);
					if (box[i][j][k] == 1) {
						queue.add(new Tomato(i, j, k));
					}
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
			int z = tomato.z;

			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];

				if (nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H) {
					if (box[nz][ny][nx] == 0) {
						box[nz][ny][nx] = box[z][y][x] + 1;
						queue.add(new Tomato(nz, ny, nx));
					}
				}
			}
		}

		int maxDay = 0;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (box[i][j][k] == 0) {
						return -1;
					}
					maxDay = Math.max(maxDay, box[i][j][k]);
				}
			}
		}

		return maxDay - 1;

	}

	static class Tomato {
		int x, y, z;

		public Tomato(int z, int y, int x) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

}
