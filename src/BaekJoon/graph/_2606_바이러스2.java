package BaekJoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _2606_바이러스2 {

	static List<Integer>[] graph;
	static boolean[] visited;
	static int count;

	public static void dfs(int node) {
		visited[node] = true;
		count++;

		for (int next : graph[node]) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int com = Integer.parseInt(br.readLine());
		int pair = Integer.parseInt(br.readLine());

		graph = new ArrayList[com + 1];
		visited = new boolean[com + 1];

		for (int i = 0; i <= com; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < pair; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			graph[to].add(from);
		}
		dfs(1);
		bw.write(String.valueOf(count - 1));
		bw.flush();
		bw.close();
	}

}
