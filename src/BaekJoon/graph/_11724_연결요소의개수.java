package BaekJoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _11724_연결요소의개수 {
	static List<Integer>[] graph;
	static boolean[] visited;

	public static void dfs(int node) {
		visited[node] = true;
		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}

		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}

		System.out.println(count);
	}

}
