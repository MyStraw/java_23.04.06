package _백준대회.전남대학교2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class C번_나무가되고싶다 {
	static int N, M, K, C;
	static char[][] chess;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class State {
		int x, y, time, hottest;

		State(int x, int y, int time, int hottest) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.hottest = hottest;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		chess = new char[N][M];
		int startX = -1, startY = -1;

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				chess[i][j] = line.charAt(j);
				if (chess[i][j] == 'S') {
					startX = i;
					startY = j;
				}
			}
		}

		System.out.println(bfs(startX, startY));
	}

	static int bfs(int startX, int startY) {
		Queue<State> que = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][101];

		que.offer(new State(startX, startY, 0, 0));
		visited[startX][startY][0] = true;

		while (!que.isEmpty()) {
			State current = que.poll();

			if (chess[current.x][current.y] == 'E') {
				return current.time;
			}

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || chess[nx][ny] == '#')
					continue;

				int newHot = updateHot(current.hottest, chess[nx][ny]);
				if (newHot >= 100)
					continue;

				if (!visited[nx][ny][newHot]) {
					visited[nx][ny][newHot] = true;
					que.offer(new State(nx, ny, current.time + 1, newHot));
				}
			}

			int newHot = updateHot(current.hottest, chess[current.x][current.y]);
			if (newHot < 100 && !visited[current.x][current.y][newHot]) {
				visited[current.x][current.y][newHot] = true;
				que.offer(new State(current.x, current.y, current.time + 1, newHot));
			}
		}

		return -1;
	}

	static int updateHot(int currentHot, char type) {
		if (type == 'H' || type == 'S') {
			return Math.max(0, currentHot - K);
		} else {
			return Math.min(100, currentHot + C);
		}
	}
}
