package BaekJoon.notyet;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1926_그림 {
	static int n, m;
	static int[][] canvas;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 }; // 이동 좌표, 상하좌루
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		canvas = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				canvas[i][j] = sc.nextInt();
			}
		}

		int count = 0; // 그림개수
		int maxArea = 0; // 가장큰 그림 넓이

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && canvas[i][j] == 1) {
					count++;
					maxArea = Math.max(maxArea, bfs(i, j));
				}
			}
		}

		System.out.println(count);
		System.out.println(maxArea);
	}

	static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;

		int area = 0;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			area++;

			for (int i = 0; i < 4; i++) {
				int nx = current[0] + dx[i];
				int ny = current[1] + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (!visited[nx][ny] && canvas[nx][ny] == 1) {
						visited[nx][ny] = true;
						queue.add(new int[] { nx, ny });
					}
				}
			}
		}

		return area;
	}

}
