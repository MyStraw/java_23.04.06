package BaekJoon.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSWithStack {
	static List<Integer>[] graph;
	static boolean[] visited;

	public static void dfs(int start) {
		Stack<Integer> stack = new Stack<>();
		stack.push(start);

		while (!stack.isEmpty()) {
			int node = stack.pop();

			if (!visited[node]) {
				visited[node] = true;
				System.out.println(node + " ");

				// 인접 노드를 반대 순서로 스택에 추가
				List<Integer> neighbors = graph[node];
				for (int i = neighbors.size() - 1; i >= 0; i--) {
					int next = neighbors.get(i);
					if (!visited[next]) {
						stack.push(next);
					}
				}
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
