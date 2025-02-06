package BaekJoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1012_유기농배추_bfs {
	// 방향을 지정해주는 배열. 좌표가 필요한 문제. 상하좌우 이동을 설정.
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken()); // 가로길이. 2차배열 할때 주의!
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[][] ground = new int[N][M];// x와y 좌표 주의
			boolean[][] visited = new boolean[N][M]; // 방문을 했는지 확인하는것도 2차배열

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken()); // X랑 Y 주의!
				ground[Y][X] = 1;
			}

			int wormCount = 0;
			// 여기부터 배추밭 돌아댕기며 BFS담색을 한다. 배추가 뜨문뜨문 있으니 다 돌아다녀봐야겠지
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (ground[i][j] == 1 && !visited[i][j]) {
						bfs(ground, visited, i, j, N, M);
						wormCount++;
					}
				}
			}
			sb.append(wormCount);
			sb.append("\n"); // BufferedWriter 에는 newLine()메서드가 있다.
		}
		System.out.println(sb);
	}

	public static void bfs(int[][] ground, boolean[][] visited, int startY, int startX, int N, int M) {
		// int N = ground.length;// 파라미터로 받아도 좋지만, 이렇게 해도~
		// int M = ground[0].length; //

		Queue<int[]> queue = new LinkedList<>(); // bfs니까 큐 사용. 좌표니까 1차배열로 x,y 좌표를 넣기
		queue.offer(new int[] { startY, startX }); // add 써도되지만 offer는 큐가 넘쳐도 false만 반환. 예외를 날리지 않음.
		visited[startY][startX] = true; // 첫 스타트 지점은 당연히 방문하고 있으니 true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[1];
			int y = now[0];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i]; // 상하 살피기
				int ny = y + dy[i]; // 좌우 살피기

				if (nx >= 0 && ny >= 0 && nx < M && ny < N && ground[ny][nx] == 1 && !visited[ny][nx]) {
					// 밭 범위 안벗어나는 조건과, 양배추가 있고 방문하지 않은곳 찾은뒤
					visited[ny][nx] = true; // 인접한곳 방문하면서 true로 바꿔주고
					queue.offer(new int[] { ny, nx }); // 자리 옮길곳(인접) 큐에 넣어준다.
				}
			}
		}
	}

}
