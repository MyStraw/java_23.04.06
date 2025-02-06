package _백준대회.SciOI_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A번_기속사소등 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 집합 A를 HashSet으로 저장 (빠른 검색을 위해)
		HashSet<Integer> setA = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			setA.add(Integer.parseInt(st.nextToken()));
		}

		// 각 방의 초기 상태 저장
		int[] rooms = new int[N];
		st = new StringTokenizer(br.readLine());
		int offCount = 0; // 초기에 꺼진 방의 수
		for (int i = 0; i < N; i++) {
			rooms[i] = Integer.parseInt(st.nextToken());
			if (rooms[i] == 0)
				offCount++;
		}

		// BFS를 위한 큐
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];

		// 초기에 끌 수 있는 방들을 큐에 추가
		for (int i = 0; i < N; i++) {
			if (rooms[i] == 1 && setA.contains(countPreviousOff(rooms, i))) {
				queue.offer(i);
				visited[i] = true;
			}
		}

		// BFS로 방들을 처리
		while (!queue.isEmpty()) {
			int current = queue.poll();
			rooms[current] = 0;
			offCount++;

			// 현재 방 이후의 방들을 확인
			for (int next = current + 1; next < N; next++) {
				if (!visited[next] && rooms[next] == 1) {
					int prevOff = countPreviousOff(rooms, next);
					if (setA.contains(prevOff)) {
						queue.offer(next);
						visited[next] = true;
					}
				}
			}
		}

		// 켜져있는 방의 수 출력
		System.out.println(N - offCount);
	}

	// 특정 방 이전까지 꺼진 방의 수를 세는 함수
	private static int countPreviousOff(int[] rooms, int index) {
		int count = 0;
		for (int i = 0; i < index; i++) {
			if (rooms[i] == 0)
				count++;
		}
		return count;
	}

}
