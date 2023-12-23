package BaekJoon.graph;

import java.util.ArrayList;
import java.util.List;

public class DFSExample2 {
	static List<List<Integer>> graph;
	static boolean[] visited;

	public static void dfs(int node) {
		visited[node] = true;
		System.out.println(node + " ");

		for (int next : graph.get(node)) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	public static void main(String[] args) {
		int n = 6; // 정점의 수
		graph = new ArrayList<>();
		visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		// 그래프 구성 예시
		graph.get(1).add(2);
		graph.get(2).add(1);
		graph.get(1).add(3);
		graph.get(3).add(1);
		graph.get(2).add(4);
		graph.get(4).add(2);		
		graph.get(2).add(5);
		graph.get(5).add(2);
		graph.get(3).add(6);
		graph.get(6).add(3);
		// ... 나머지 연결 정보 추가 ...

		dfs(1); // 1번 정점부터 탐색 시작
	}
}