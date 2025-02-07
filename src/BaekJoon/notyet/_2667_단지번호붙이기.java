package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					int count = dfs(i, j);
					list.add(count);
				}
			}
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		sb.append(list.size()).append("\n");
		for (int num : list) {
			sb.append(num).append("\n");
		}
		System.out.print(sb);
	}

	static int dfs(int x, int y) {
		visited[x][y] = true;
		int count = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					count += dfs(nx, ny);
				}
			}
		}
		return count;
	}

}
