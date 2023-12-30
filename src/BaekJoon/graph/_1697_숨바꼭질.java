package BaekJoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697_숨바꼭질 {
	 static final int MAX = 100000; // 가능한 최대 위치
	    static List<Integer>[] graph;
	    static boolean[] visited;
	    
	    private static int bfs(int start, int end) {
	        Queue<int[]> queue = new LinkedList<>();
	        queue.add(new int[]{start, 0}); // 현재 위치와 시간

	        while (!queue.isEmpty()) {
	            int[] current = queue.poll();
	            int currentPosition = current[0];
	            int currentTime = current[1];

	            visited[currentPosition] = true;

	            if (currentPosition == end) {
	                return currentTime;
	            }

	            for (int nextPosition : graph[currentPosition]) {
	                if (!visited[nextPosition]) {
	                    queue.add(new int[]{nextPosition, currentTime + 1});
	                    visited[nextPosition] = true;
	                }
	            }
	        }

	        return -1;
	    }
	    
	    

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
	        graph = new ArrayList[MAX + 1];
	        visited = new boolean[MAX + 1];

	        for (int i = 0; i <= MAX; i++) {
	            graph[i] = new ArrayList<>();
	        }

	        // 그래프 구성
	        for (int i = 0; i <= MAX; i++) {
	            if (i - 1 >= 0) graph[i].add(i - 1); // 한 칸 뒤로 이동
	            if (i + 1 <= MAX) graph[i].add(i + 1); // 한 칸 앞으로 이동
	            if (2 * i <= MAX) graph[i].add(2 * i); // 순간이동
	        }

	        // BFS로 최단 시간 계산
	        System.out.println(bfs(N, K));
	    }

	 
}
