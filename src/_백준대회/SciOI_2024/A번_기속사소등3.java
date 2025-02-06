package _백준대회.SciOI_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A번_기속사소등3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 불리언으로 다시
		boolean[] possibleCounts = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			possibleCounts[Integer.parseInt(st.nextToken())] = true;
		}

		//방 상태
		int[] room = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}

		//현 상태 기록
		HashSet<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();

		// 시간 단축위해 비트마스크?? 인가 그거 
		int initialState = 0;
		for (int i = 0; i < N; i++) {
			if (room[i] == 0)
				initialState |= (1 << i);
		}

		queue.offer(initialState);
		visited.add(initialState);
		int bestState = initialState;

		while (!queue.isEmpty()) {
			int currentState = queue.poll();
			int offCount = Integer.bitCount(currentState);

			// 각방 소등 가능여부 체크
			for (int i = 0; i < N; i++) {
				if ((currentState & (1 << i)) != 0)
					continue; // 꺼진방은 넘어가고

				// i번 방 이전까지의 꺼진방수 계산
				int prevOff = 0;
				for (int j = 0; j < i; j++) {
					if ((currentState & (1 << j)) != 0)
						prevOff++;
				}

				// 소등 가능하면 새로운 상태로 바꿈
				if (possibleCounts[prevOff]) {
					int newState = currentState | (1 << i);
					if (!visited.contains(newState)) {
						queue.offer(newState);
						visited.add(newState);
						if (Integer.bitCount(newState) > Integer.bitCount(bestState)) {
							bestState = newState;
						}
					}
				}
			}
		}
	
		System.out.println(N - Integer.bitCount(bestState));
	}
}
