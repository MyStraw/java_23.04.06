package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11000_강의실배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 강의 수
		int[][] lecture = new int[N][2]; // 강의 시간을 저장할 배열

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			lecture[i][0] = Integer.parseInt(st.nextToken()); // 강의 시작 시간
			lecture[i][1] = Integer.parseInt(st.nextToken()); // 강의 종료 시간
		}

		// 강의를 시작 시간 기준으로 정렬
		Arrays.sort(lecture, (a, b) -> a[0] - b[0]);

		// 우선순위 큐 초기화 (강의 종료 시간 기준으로 정렬)
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		// 첫 강의의 종료 시간을 우선순위 큐에 추가
		pq.add(lecture[0][1]);

		for (int i = 1; i < N; i++) {
			// 현재 강의의 시작 시간이 큐의 가장 빠른 종료 시간보다 같거나 늦다면, 재사용 가능
			if (lecture[i][0] >= pq.peek()) {
				pq.poll(); // 기존 강의실 재사용
			}
			// 현재 강의 종료 시간을 큐에 추가 (새로운 강의실 사용 혹은 기존 강의실 재사용)
			pq.add(lecture[i][1]);
		}

		// 필요한 강의실의 수는 우선순위 큐의 크기와 동일
		System.out.println(pq.size());
	}

}
