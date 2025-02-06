package _백준대회.나는코더다_2024_송년대회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class L번_정기모임6 {

	static int N, M, Q;
	static int[] depth, parent;
	static List<Integer>[] graph;
	static int[][] up;
	static int LOG;

	// 깊이 우선 탐색 (DFS)
	static void dfs(int node, int par) {
		parent[node] = par == -1 ? node : par; // 부모가 없으면 자기 자신을 부모로 설정
		for (int neighbor : graph[node]) {
			if (neighbor != par) {
				depth[neighbor] = depth[node] + 1;
				dfs(neighbor, node);
			}
		}
	}

	// LCA 전처리
	static void preprocessLCA() {
		for (int i = 1; i <= N; i++) {
			up[i][0] = parent[i];
		}

		for (int j = 1; j < LOG; j++) {
			for (int i = 1; i <= N; i++) {
				if (up[i][j - 1] != -1) {
					up[i][j] = up[up[i][j - 1]][j - 1];
				}
			}
		}
	}

	// 최소 공통 조상 (LCA) 계산
	static int getLCA(int u, int v) {
		if (u == -1 || v == -1)
			return -1; // 잘못된 입력 처리

		if (depth[u] < depth[v]) {
			int temp = u;
			u = v;
			v = temp;
		}

		int diff = depth[u] - depth[v];
		for (int i = 0; i < LOG; i++) {
			if (((diff >> i) & 1) == 1) {
				if (up[u][i] == -1)
					return -1; // 범위 초과 방지
				u = up[u][i];
			}
		}

		if (u == v)
			return u;

		for (int i = LOG - 1; i >= 0; i--) {
			if (up[u][i] != up[v][i]) {
				if (up[u][i] == -1 || up[v][i] == -1)
					return -1; // 범위 초과 방지
				u = up[u][i];
				v = up[v][i];
			}
		}
		return parent[u];
	}

	// 두 정점 간 거리 계산
	static int getDistance(int u, int v) {
		int lca = getLCA(u, v);
		return depth[u] + depth[v] - 2 * depth[lca];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		// 동적으로 노드 확장 고려
		int maxNodes = N + (N * 10); // 예상 가능한 최대 노드 수 (안전 마진 포함)

		LOG = (int) Math.ceil(Math.log(maxNodes) / Math.log(2)) + 1;
		graph = new ArrayList[maxNodes + 1];
		depth = new int[maxNodes + 1];
		parent = new int[maxNodes + 1];
		up = new int[maxNodes + 1][LOG];

		for (int i = 1; i <= maxNodes; i++) {
			graph[i] = new ArrayList<>();
			Arrays.fill(up[i], -1);
		}

		int nodeCount = N;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			int prev = u;
			for (int j = 0; j < c; j++) {
				nodeCount++;
				graph[prev].add(nodeCount);
				graph[nodeCount].add(prev);
				prev = nodeCount;
			}
			graph[prev].add(v);
			graph[v].add(prev);
		}

		// DFS로 깊이 및 부모 정보 설정
		dfs(1, -1);
		preprocessLCA();

		// 주민 정보 저장
		int[] x = new int[M];
		int[] d = new int[M];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}

		// 쿼리 처리
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken()) - 1;

			int commonCount = 0;
			for (int j = l; j <= r; j++) {
				for (int k = j + 1; k <= r; k++) {
					if (getDistance(x[j], x[k]) <= Math.min(d[j], d[k])) {
						commonCount++;
					}
				}
			}

			sb.append(commonCount).append("\n");
		}

		// 결과 출력
		System.out.print(sb);
	}

}
