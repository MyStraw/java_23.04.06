package BaekJoon.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1697_숨바꼭질2 {
	static final int MAX = 100000;

	public static int bfs(int start, int end) {
		boolean[] visited = new boolean[MAX + 1]; // 방문 여부를 체크하는 배열
		Queue<int[]> queue = new LinkedList<>(); // 위치와 시간을 저장할 큐
		queue.offer(new int[] { start, 0 }); // 시작 위치와 시간 0을 큐에 넣음

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int currentPosition = current[0];
			int currentTime = current[1];

			visited[currentPosition] = true; // 현재 위치 방문 처리

			// 다음에 이동할 수 있는 위치들: 현재 위치에서 -1, +1, *2
			int[] nextPositions = { currentPosition - 1, currentPosition + 1, currentPosition * 2 };

			for (int nextPosition : nextPositions) {
				if (nextPosition >= 0 && nextPosition <= MAX && !visited[nextPosition]) {
					if (nextPosition == end) {
						return currentTime + 1; // 동생을 찾은 경우, 현재 시간 + 1 반환
					}
					queue.offer(new int[] { nextPosition, currentTime + 1 }); // 다음 위치와 현재 시간 + 1을 큐에 넣음
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (N == K) {
			System.out.println(0);
		} else {
			System.out.println(bfs(N, K));
		}

	}

}
