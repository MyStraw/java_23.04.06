package _백준대회.디미고챌린지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D번2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 음식의 수
		int M = Integer.parseInt(st.nextToken()); // 학생의 수

		boolean[] used = new boolean[N + 1]; // 음식을 사용했는지 여부를 추적
		int maxHappiness = 0;

		// 각 학생마다 선택할 수 있는 음식과 그 행복도를 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()); // 먹을 수 있는 음식의 개수

			// 우선순위 큐에 가능한 음식들을 추가
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

			for (int j = 0; j < l; j++) {
				int p = Integer.parseInt(st.nextToken()); // 음식 번호
				int v = Integer.parseInt(st.nextToken()); // 행복도

				if (!used[p]) {
					pq.offer(new int[] { p, v }); // 사용하지 않은 음식만 큐에 넣는다
				}
			}

			// 큐에서 가장 큰 행복도를 가지는 음식을 선택
			if (!pq.isEmpty()) {
				int[] bestChoice = pq.poll();
				used[bestChoice[0]] = true; // 선택한 음식을 사용처리
				maxHappiness += bestChoice[1]; // 최대 행복도 합산
			}
		}

		System.out.println(maxHappiness);
	}

}
