package BaekJoon.graph.기본코드;

import java.util.ArrayList;
import java.util.List;

public class List_DFS_recursion {
	public void dfs(int start, List<List<Integer>> graph, boolean[] visited) {
		// 현재 노드를 방문 처리
		visited[start] = true;
		System.out.print(start + " ");
		// 현재 노드와 연결된 다른 노드를 재귀적으로 방문
		for (int neighbor : graph.get(start)) {
			if (!visited[neighbor]) {
				dfs(neighbor, graph, visited);
			}
		}
	}

	public static void main(String[] args) {
		int n = 6; // 정점의 수
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
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

		boolean[] visited = new boolean[n + 1];
		List_DFS_recursion dfsRecur = new List_DFS_recursion();
		dfsRecur.dfs(1, graph, visited);
	}
}
