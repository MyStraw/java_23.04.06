package _백준대회.SciOI_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A번_기속사소등2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 집합 A 저장
		HashSet<Integer> setA = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}

		// 각 방 주어진 상태
		int[] room = new int[N];
		// 소등된 방들 누적합
		int[] nuSum = new int[N + 1]; // 인덱스 0은 버리자. 헷갈리지마

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			room[i] = Integer.parseInt(st.nextToken());
			if (room[i] == 0) {
				nuSum[i + 1] = nuSum[i] + 1;
			} else {
				nuSum[i + 1] = nuSum[i];
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N]; // 큐에 방문쓰면 BFS 아닌가?

		// 처음에 끌 수 있는 방들을 큐에 추가
		for (int i = 0; i < N; i++) {
			if (room[i] == 1 && setA.contains(nuSum[i])) {
				queue.offer(i);
				visited[i] = true;
			}
		}

		// BFS? 로 순회하면서
		while (!queue.isEmpty()) {
			int current = queue.poll();
			room[current] = 0;

			// 현재까지의 방 이후로 업데이트 시킴. 누적합을.
			for (int i = current + 1; i <= N; i++) {
				nuSum[i]++;
			}

			// 현재 방 이후의 방들을 확인
			for (int next = current + 1; next < N; next++) {
				if (!visited[next] && room[next] == 1) {
					if (setA.contains(nuSum[next])) {
						queue.offer(next);
						visited[next] = true;
					}
				}
			}
		}

		// 1인거(꺼진거)만 카운트
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (room[i] == 1)
				result++;
		}

		System.out.println(result);
	}

}
