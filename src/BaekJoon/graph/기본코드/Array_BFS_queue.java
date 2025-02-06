package BaekJoon.graph.기본코드;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Array_BFS_queue {
	public static void bfs(int start, List<Integer>[] graph, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");

			for (int next : graph[node]) {
				if (!visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	}

	public static void main(String[] args) {
		int n = 6; // 정점의 수
		List<Integer>[] graph = new ArrayList[n + 1];
		boolean [] visited = new boolean[n + 1];
		// 그래프 초기화 및 구성 ...
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
	
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

		bfs(1, graph, visited); // 1번 정점부터 탐색 시작
	}
}