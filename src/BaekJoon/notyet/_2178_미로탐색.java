package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2178_미로탐색 {
	static int n, m;
	static int[][] maze;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maze = new int[n][m];
		visited = new boolean[n][m];

		// 미로 입력
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}

		// BFS 실행 및 결과 출력
		System.out.println(bfs(0, 0));
	}

	// BFS 함수
	static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y, 1 }); // 시작 위치와 시작 위치의 카운트 (1)
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentX = current[0];
			int currentY = current[1];
			int count = current[2];

			// 목표 위치에 도달한 경우
			if (currentX == n - 1 && currentY == m - 1) {
				return count;
			}

			// 네 방향 탐색
			for (int i = 0; i < 4; i++) {
				int nx = currentX + dx[i];
				int ny = currentY + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m && maze[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny, count + 1 });
				}
			}
		}

		return -1; // 도달할 수 없는 경우
	}

}
