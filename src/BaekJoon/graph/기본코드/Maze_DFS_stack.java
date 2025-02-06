package BaekJoon.graph.기본코드;

import java.util.Stack;

public class Maze_DFS_stack {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public void dfs(int startX, int startY, int[][] maze, boolean[][] visited) {
		int n = maze.length;
		int m = maze[0].length;

		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] { startX, startY });
		visited[startX][startY] = true;

		while (!stack.isEmpty()) {
			int[] current = stack.pop();
			int x = current[0];
			int y = current[1];
			System.out.println("Visiting: (" + x + ", " + y + ")");

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
//			for (int i = 3; i >= 0; i--) { //왼쪽부터 할때
//		        int nx = x + dx[i];
//		        int ny = y + dy[i];	

				if (nx >= 0 && ny >= 0 && nx < n && ny < m && maze[nx][ny] == 0 && !visited[nx][ny]) {
					stack.push(new int[] { nx, ny });
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

		Maze_DFS_stack dfsExample = new Maze_DFS_stack();
		dfsExample.dfs(0, 0, maze, visited); // 시작 좌표 (0, 0)
	}
}