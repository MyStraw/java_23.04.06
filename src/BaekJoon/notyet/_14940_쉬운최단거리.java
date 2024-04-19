package BaekJoon.notyet;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class _14940_쉬운최단거리 { //bfs
	static int n, m;
	static int[][] map;
	static int[][] distance; // 각 지점까지의 거리를 저장할 배열
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우 이동
	static int[] dy = { 0, 0, -1, 1 };

	public static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y));
		distance[x][y] = 0;

		while (!q.isEmpty()) {
			Point current = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 1 && distance[nx][ny] == -1) {
					distance[nx][ny] = distance[current.x][current.y] + 1;
					q.add(new Point(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		distance = new int[n][m];

		int startX = 0, startY = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				distance[i][j] = -1; // 초기 거리는 -1로 설정
				if (map[i][j] == 2) {
					startX = i;
					startY = j;
					map[i][j] = 1; // 목표지점도 갈 수 있는 땅으로 처리
				}
			}
		}

		bfs(startX, startY); // BFS 실행

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					System.out.print("0 ");
				else
					System.out.print(distance[i][j] + " ");
			}
			System.out.println();
		}
	}

}
