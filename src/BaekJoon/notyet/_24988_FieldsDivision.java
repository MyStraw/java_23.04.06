package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _24988_FieldsDivision {
	static List<Integer>[] graph;
	static char[] assignment;
	static int[] yield;
	static long sumA = 0, sumB = 0;
	static boolean possible = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		assignment = new char[N + 1];
		yield = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			yield[i] = 2 * i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= N; i++) {
			if (assignment[i] == 0) {
				dfs(i, 'A');
			}
		}

		if (!possible) {
			System.out.println("IMPOSSIBLE");
		} else {
			StringBuilder result = new StringBuilder();
			for (int i = 1; i <= N; i++) {
				result.append(assignment[i]);
			}
			System.out.println(result.toString());
		}
	}

	private static void dfs(int node, char assign) {
		if (assignment[node] != 0) {
			if (assignment[node] != assign) {
				possible = false;
			}
			return;
		}
		assignment[node] = assign;
		if (assign == 'A') {
			sumA += yield[node];
		} else {
			sumB += yield[node];
		}

		for (int neighbor : graph[node]) {
			dfs(neighbor, (assign == 'A') ? 'B' : 'A');
		}
	}

}
