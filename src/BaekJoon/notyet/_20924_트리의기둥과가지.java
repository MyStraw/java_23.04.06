package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _20924_트리의기둥과가지 {
	static int n, r;
	static int pillar, max, gigaNode;
	static boolean[] visited;
	static ArrayList<Node>[] nodeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		nodeList = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++) {
			nodeList[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			nodeList[n1].add(new Node(n2, cost));
			nodeList[n2].add(new Node(n1, cost));
		}

		pillar = 0;
		max = 0;
		if (n != 1) {
			visited = new boolean[n + 1];
			findPillarDFS(r, 0);
			findMaxDFS(gigaNode, 0);
		}

		sb.append(pillar).append(" ").append(max);
		System.out.println(sb.toString());
	}

	public static void findPillarDFS(int n, int total) {
		if (nodeList[n].size() > 2 || (nodeList[n].size() == 1 && n != r) || (nodeList[n].size() == 2 && n == r)) {
			pillar = total;
			gigaNode = n;
			return;
		}

		for (int i = 0; i < nodeList[n].size(); i++) {
			Node next = nodeList[n].get(i);
			if (!visited[next.num]) {
				visited[next.num] = true;
				findPillarDFS(next.num, total + next.cost);
			}
		}
	}

	public static void findMaxDFS(int n, int total) {
		if (nodeList[n].size() == 1) { 
			max = Math.max(max, total);
			return;
		}

		for (int i = 0; i < nodeList[n].size(); i++) {
			Node next = nodeList[n].get(i);
			if (!visited[next.num]) {
				visited[n] = true;
				total += next.cost;
				findMaxDFS(next.num, total);
				total -= next.cost;
				visited[n] = false;
			}
		}
	}

	public static class Node {
		int num;
		int cost;

		public Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
	}

}
