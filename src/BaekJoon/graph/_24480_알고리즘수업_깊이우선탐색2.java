package BaekJoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _24480_알고리즘수업_깊이우선탐색2 {
	static List<Integer>[] graph;
	static boolean[] visited;
	static int[] order;
	static int count = 1;

	public static void dfs(int node) {
		visited[node] = true;
		order[node] = count++;

		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		order = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>(); // 각 객체를 안에 넣어주는 초기화
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i], new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
			});
		}

		dfs(R);

		for (int i = 1; i <= N; i++) {
			bw.write(String.valueOf(order[i]));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
