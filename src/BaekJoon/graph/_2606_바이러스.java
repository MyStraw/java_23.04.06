package BaekJoon.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _2606_바이러스 {
	static List<Integer>[] network;
	static boolean[] visited;
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 컴퓨터의 수
		int pairs = sc.nextInt(); // 연결 쌍의 수

		network = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			network[i] = new ArrayList<>();
		}

		for (int i = 0; i < pairs; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			network[a].add(b);
			network[b].add(a); // 양방향 연결
		}

		visited = new boolean[n + 1];
		dfs(1); // 1번 컴퓨터부터 탐색 시작

		System.out.println(count - 1); // 1번 컴퓨터 제외한 수 출력
	}

	static void dfs(int start) {
		visited[start] = true;
		count++;

		for (int i : network[start]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}
}
