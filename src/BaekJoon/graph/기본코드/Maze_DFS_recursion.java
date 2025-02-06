package BaekJoon.graph.기본코드;

public class Maze_DFS_recursion {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public void dfs(int x, int y, int[][] maze, boolean[][] visited) {
		int n = maze.length;
		int m = maze[0].length;

		visited[x][y] = true;
		System.out.println("Visiting: (" + x + ", " + y + ")");

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < m && maze[nx][ny] == 0 && !visited[nx][ny]) {
				dfs(nx, ny, maze, visited);
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
		boolean[][] visited = new boolean[maze.length][maze[0].length]; //x와 y를 잘 구분하자. dfs 메소드에서 헷갈릴수있음

		Maze_DFS_recursion dfsExample = new Maze_DFS_recursion();
		dfsExample.dfs(0, 0, maze, visited); // 시작 좌표 (0, 0)
	}
}
