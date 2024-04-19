package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//앞에선 deque으로 poll 한걸 다시 add 하면서 회전을 시켰는데, 이건 메모리 초과가 났다. 이것 말고 배열을 그대로 쓰고
//index만을 이용하는게 낫다고 판단. 가령 길이 5짜리 배열에 7의 입력이 있다면, 오른칸으로 7을 가야하는데 이때 %5 등을 쓰면 된다.

public class _2346_풍선터뜨리기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] balloons = new int[n];
		boolean[] pop = new boolean[n]; // 터진 풍선을 추적하기 위한 배열

		for (int i = 0; i < n; i++) {
			balloons[i] = Integer.parseInt(st.nextToken());
		}

		int currentIndex = 0; // 현재 풍선의 위치
		int move; // 이동해야 할 거리
		int count = n; // 남은 풍선의 수

		// 모든 풍선을 터뜨릴 때까지 반복
		while (count > 0) {
			// 현재 풍선을 터뜨림
			System.out.print((currentIndex + 1) + " ");
			pop[currentIndex] = true;
			count--;

			if (count == 0)
				break; // 마지막 풍선을 터뜨렸다면 종료

			move = balloons[currentIndex];
			// 오른쪽 또는 왼쪽으로 이동
			while (move != 0) {
				currentIndex = (currentIndex + (move > 0 ? 1 : -1) + n) % n; // 원형 구조 유지
				if (!pop[currentIndex]) { // 아직 터지지 않은 풍선이면 이동 카운트 감소
					move = move > 0 ? move - 1 : move + 1;
				}
			}
		}
	}
}