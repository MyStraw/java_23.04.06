package BaekJoon.graph.기본코드;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class List_DFS_stack {
	public void dfs(int start, List<List<Integer>> graph, boolean[] visited) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start);

		while (!stack.isEmpty()) {
			int node = stack.pop();

			if (!visited[node]) {
				visited[node] = true;
				System.out.print(node + " ");
//				List<Integer> neighbors = graph.get(node); 이렇게 하면 왼쪽부터 오른속으로 탐색
//				Collections.reverse(neighbors); // 리스트를 역순으로 뒤집기
				// 인접 노드를 스택에 추가
				for (int neighbor : graph.get(node)) { // 이건 오른쪽부터 방문하게 된다. 순서가 좀 달라진다.
					if (!visited[neighbor]) {
						stack.push(neighbor);
					}
				}
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
		List_DFS_stack dfsStack = new List_DFS_stack();
		dfsStack.dfs(1, graph, visited); // 시작 노드를 1로 설정하여 DFS 수행
	}
}