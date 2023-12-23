package BaekJoon.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _24479_알고리즘수업_깊이우선탐색1 {
	static List<Integer>[] graph;
	static boolean[] visited;
	static int[] order;
	static int count = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 정점의 수
		int m = sc.nextInt(); // 간선의 수
		int r = sc.nextInt(); // 시작 정점

		graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph[u].add(v);
			graph[v].add(u); // 양방향 간선
		}

		// 각 정점을 오름차순으로 방문하기 위해 인접 리스트 정렬
		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}

		visited = new boolean[n + 1];
		order = new int[n + 1];
		dfs(r);

		for (int i = 1; i <= n; i++) {
			System.out.println(order[i]);
		}
	}

	static void dfs(int node) {
		visited[node] = true;
		order[node] = count++;

		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
}
