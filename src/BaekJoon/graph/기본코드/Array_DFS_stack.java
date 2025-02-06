package BaekJoon.graph.기본코드;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Array_DFS_stack {
    public static void dfs(int start, List<Integer>[] graph, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");
//                List<Integer> neighbors = graph[node];
//                for (int i = 0; i < neighbors.size(); i++) {
//                    int next = neighbors.get(i);
//                    if (!visited[next]) {
//                        stack.push(next);
//                    }
//                }

//                for (int neighbor : graph[node]) {
//                    if (!visited[neighbor]) {
//                        stack.push(neighbor);
//                    }
//                }

                // 인접 노드를 반대 순서로 스택에 추가
                List<Integer> neighbors = graph[node];
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int next = neighbors.get(i);
                    if (!visited[next]) {
                        stack.push(next);
                    }
                }

//				List<Integer> neighbors = new ArrayList<>(graph[node]);
//				Collections.reverse(neighbors);
//				for (int neighbor : graph[node]) {
//					if (!visited[neighbor]) {
//						stack.push(neighbor);
//					}
//				}
            }
        }
    }
    public static void main(String[] args) {
        int n = 6; // 정점의 수
        List<Integer>[] graph = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        dfs(1, graph, visited); // 1번 정점부터 탐색 시작
    }
}