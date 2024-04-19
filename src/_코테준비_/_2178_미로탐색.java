package _코테준비_;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2178_미로탐색 {
	static int[][] maze; // 미로 정보와 각 위치까지의 최단 거리를 저장할 배열
	static boolean[][] visited; // 방문 여부를 체크할 배열
	static int N, M; // 미로의 크기
	static int[] dx = { -1, 1, 0, 0 }; // x축 이동 (상, 하)
	static int[] dy = { 0, 0, -1, 1 }; // y축 이동 (좌, 우)

	// BFS 메서드
	public static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>(); // 위치 정보를 저장할 큐
		queue.offer(new int[] { x, y }); // 시작 위치를 큐에 추가
		visited[x][y] = true; // 시작 위치 방문 처리

		while (!queue.isEmpty()) {
			int[] current = queue.poll(); // 현재 위치 정보를 큐에서 꺼냄
			for (int i = 0; i < 4; i++) { // 상하좌우 탐색
				int nx = current[0] + dx[i]; // 새로운 x 위치
				int ny = current[1] + dy[i]; // 새로운 y 위치

				// 미로 범위 내에 있고, 이동할 수 있는 칸이며, 아직 방문하지 않았다면
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && maze[nx][ny] == 1 && !visited[nx][ny]) {
					queue.offer(new int[] { nx, ny }); // 새 위치를 큐에 추가
					maze[nx][ny] = maze[current[0]][current[1]] + 1; // 이동 거리 갱신
					visited[nx][ny] = true; // 방문 처리
				}
			}
		}

		return maze[N - 1][M - 1]; // 최단 거리 반환
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		maze = new int[N][M];
		visited = new boolean[N][M];

		// 미로 정보 입력
		for (int i = 0; i < N; i++) {
			String line = scanner.next();
			for (int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}

		System.out.println(bfs(0, 0)); // BFS 실행하여 최단거리 출력
	}

}
