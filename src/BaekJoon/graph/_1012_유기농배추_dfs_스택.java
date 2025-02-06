package BaekJoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _1012_유기농배추_dfs_스택 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] ground = new int[N][M];
			boolean[][] visited = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				ground[Y][X] = 1;
			}

			int wormCount = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (ground[i][j] == 1 && !visited[i][j]) {
						dfs(ground, visited, i, j, N, M);
						wormCount++;
					}
				}
			}
			sb.append(wormCount);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int[][] ground, boolean[][] visited, int startY, int startX, int N, int M) {
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] { startY, startX }); 
		visited[startY][startX] = true;

		while (!stack.isEmpty()) { 
			int[] current = stack.pop(); 
			int x = current[1]; 
			int y = current[0]; 

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < M && ny < N && ground[ny][nx] == 1 && !visited[ny][nx]) {
					stack.push(new int[] { ny, nx });
					visited[ny][nx] = true;

				}
			}
		}
	}
}
