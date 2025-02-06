package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _11581_구호물자 {
	static ArrayList<ArrayList<Integer>> adjList;
	static boolean[] visited;
	static boolean[] recStack;
	static boolean hasCycle;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		adjList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int u = 1; u < N; u++) {
			int M = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= M; i++) {
				int v = Integer.parseInt(st.nextToken());
				adjList.get(u).add(v);
			}
		}

		visited = new boolean[N + 1];
		recStack = new boolean[N + 1];
		hasCycle = false;

		dfs(1);

		if (hasCycle) {
			System.out.println("CYCLE");
		} else {
			System.out.println("NO CYCLE");
		}

		br.close();
	}

	private static void dfs(int node) {
		if (hasCycle)
			return;
		visited[node] = true;
		recStack[node] = true;

		for (int neighbor : adjList.get(node)) {
			if (!visited[neighbor]) {
				dfs(neighbor);
			} else if (recStack[neighbor]) {
				hasCycle = true;
				return;
			}
		}

		recStack[node] = false;
	}

}
