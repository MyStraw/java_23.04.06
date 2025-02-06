package BaekJoon.graph.기본코드;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class List_BFS_queue {
	public void bfs(int start, List<List<Integer>> graph, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			System.out.print(node + " ");

			for (int neighbor : graph.get(node)) {
				if (!visited[neighbor]) {
					queue.offer(neighbor);
					visited[neighbor] = true;
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
		List_BFS_queue bfsQueue = new List_BFS_queue();
		bfsQueue.bfs(1, graph, visited);
	}
}