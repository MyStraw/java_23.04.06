package BaekJoon.graph;

import java.util.ArrayList;
import java.util.List;

public class DFSExample {
	static List<Integer>[] graph;
	static boolean[] visited;

	public static void dfs(int node) {
		visited[node] = true;
		System.out.println(node + " ");

		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	public static void main(String[] args) {
		int n = 6; // 정점의 수
		graph = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		// 그래프 초기화 및 구성 ...

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		// 그래프 구성 예시 (실제 연결 정보에 따라 추가 필요)
		graph[1].add(2);
		graph[2].add(1);
		graph[1].add(3);
		graph[3].add(1);
		graph[2].add(4);
		graph[4].add(2);
		graph[2].add(5);
		graph[5].add(2);
		graph[3].add(6);
		graph[6].add(3);
		// ... 나머지 연결 정보 추가 ...

		dfs(1); // 1번 정점부터 탐색 시작
	}
}