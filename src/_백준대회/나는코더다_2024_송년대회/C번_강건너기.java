package _백준대회.나는코더다_2024_송년대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C번_강건너기 {

	static int N;
	static boolean[][] connected;
	static List<int[]> edges = new ArrayList<>();
	static int queryCount = 0;
	static final int MAX_QUERY = 30000;

	static int query(int x, int y) throws IOException {
		queryCount++;
		if (queryCount > MAX_QUERY) {
			System.exit(0);
		}
		System.out.println("? " + x + " " + y);
		System.out.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = Integer.parseInt(br.readLine());
		if (result == -1)
			System.exit(0);
		return result;
	}

	static void outputResult() {
		System.out.println("! " + edges.size());
		for (int[] edge : edges) {
			System.out.println(edge[0] + " " + edge[1]);
		}
		System.out.flush();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		connected = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (!connected[i][j]) {
					int distance = query(i, j);
					if (distance == 1) {
						edges.add(new int[] { i, j });
						connected[i][j] = connected[j][i] = true;
					}
				}
			}
		}

		outputResult();
	}

}
