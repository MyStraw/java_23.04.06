package BaekJoon.graph.기본코드;

import java.util.LinkedList;
import java.util.Queue;

public class Maze_BFS_queue {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public void bfs(int startX, int startY, int[][] maze, boolean[][] visited) {
		int n = maze.length;
		int m = maze[0].length;

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { startX, startY });
		visited[startX][startY] = true;

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int x = current[0];
			int y = current[1];
			System.out.println("Visiting: (" + x + ", " + y + ")");

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m && maze[nx][ny] == 0 && !visited[nx][ny]) {
					queue.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] maze = { 
				{ 0, 1, 0, 0, 0 }, 
				{ 0, 1, 0, 1, 0 }, 
				{ 0, 0, 0, 1, 0 }, 
				{ 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 0 } };
		boolean[][] visited = new boolean[maze.length][maze[0].length];

		Maze_BFS_queue bfsExample = new Maze_BFS_queue();
		bfsExample.bfs(0, 0, maze, visited); // 시작 좌표 (0, 0)
	}
}