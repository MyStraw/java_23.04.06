package BaekJoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260_DFS와BFS {

	static List<Integer>[] graphDfs;
	static boolean[] visitedDfs;

	static List<Integer>[] graphBfs;
	static boolean[] visitedBfs;

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visitedBfs[start] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");

			for (int next : graphBfs[node]) {
				if (!visitedBfs[next]) {
					visitedBfs[next] = true;
					queue.add(next);
				}
			}
		}
	}

	public static void dfs(int node) {
		visitedDfs[node] = true;
		System.out.print(node + " ");

		for (int next : graphDfs[node]) {
			if (!visitedDfs[next]) {
				dfs(next);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		graphDfs = new ArrayList[n + 1];
		visitedDfs = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			graphDfs[i] = new ArrayList<>();
		}

		graphBfs = new ArrayList[n + 1];
		visitedBfs = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			graphBfs[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graphDfs[from].add(to);
			graphDfs[to].add(from);
			graphBfs[from].add(to);
			graphBfs[to].add(from);
		}
		
		for (int i = 1; i <= n; i++) {
			Collections.sort(graphBfs[i]);
			Collections.sort(graphDfs[i]);		
		}		
		
		dfs(v);
		System.out.println();
		bfs(v);
	}
}
