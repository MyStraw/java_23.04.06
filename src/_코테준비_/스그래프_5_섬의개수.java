package _코테준비_;

import java.util.Scanner;

public class 스그래프_5_섬의개수 {
	private static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int numIslands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					numIslands++;
				}
			}
		}
		return numIslands;
	}

	private static void dfs(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		char[][] grid = new char[m][n];
		for (int i = 0; i < m; i++) {
			String line = scanner.nextLine();
			for (int j = 0; j < n; j++) {
				grid[i][j] = line.charAt(j);
			}
		}
		System.out.println(numIslands(grid));
	}

}
