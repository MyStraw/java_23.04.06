package _백준대회.나는코더다_2024_송년대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class G번_지하철타고가요 {
	static final int MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] lines = new int[N][4];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 4; j++) {
				lines[i][j] = Integer.parseInt(input[j]);
			}
		}

		Map<Integer, List<Integer>> horizontal = new HashMap<>();
		Map<Integer, List<Integer>> vertical = new HashMap<>();

		for (int i = 0; i < N; i++) {
			if (lines[i][0] == lines[i][2]) {
				vertical.computeIfAbsent(lines[i][0], k -> new ArrayList<>()).add(i);
			} else {
				horizontal.computeIfAbsent(lines[i][1], k -> new ArrayList<>()).add(i);
			}
		}

		List<Integer>[] graph = new ArrayList[N];
		for (int i = 0; i < N; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			if (lines[i][0] == lines[i][2]) {
				List<Integer> hLines = horizontal.getOrDefault(lines[i][1], Collections.emptyList());
				for (int j : hLines) {
					if (isConnected(lines[i], lines[j])) {
						graph[i].add(j);
						graph[j].add(i);
					}
				}
			} else {
				List<Integer> vLines = vertical.getOrDefault(lines[i][0], Collections.emptyList());
				for (int j : vLines) {
					if (isConnected(lines[i], lines[j])) {
						graph[i].add(j);
						graph[j].add(i);
					}
				}
			}
		}

		long result = 0;
		for (int i = 0; i < N; i++) {
			int[] dist = bfs(graph, i, N);
			for (int j = 0; j < N; j++) {
				if (dist[j] != -1) {
					result = (result + (long) dist[j] * (i + 1) * (j + 1)) % MOD;
				}
			}
		}

		System.out.println(result);
	}

	static boolean isConnected(int[] line1, int[] line2) {
		int x1 = line1[0], y1 = line1[1], x2 = line1[2], y2 = line1[3];
		int x3 = line2[0], y3 = line2[1], x4 = line2[2], y4 = line2[3];
		if (x1 == x2)
			return y3 <= Math.max(y1, y2) && y4 >= Math.min(y1, y2) && Math.min(x3, x4) <= x1 && x1 <= Math.max(x3, x4);
		if (y1 == y2)
			return x3 <= Math.max(x1, x2) && x4 >= Math.min(x1, x2) && Math.min(y3, y4) <= y1 && y1 <= Math.max(y3, y4);
		return false;
	}

	static int[] bfs(List<Integer>[] graph, int start, int N) {
		int[] dist = new int[N];
		Arrays.fill(dist, -1);
		Queue<Integer> queue = new LinkedList<>();
		dist[start] = 0;
		queue.add(start);

		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int neighbor : graph[node]) {
				if (dist[neighbor] == -1) {
					dist[neighbor] = dist[node] + 1;
					queue.add(neighbor);
				}
			}
		}
		return dist;
	}

}
