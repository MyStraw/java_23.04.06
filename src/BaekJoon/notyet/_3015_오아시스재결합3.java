package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _3015_오아시스재결합3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] oasis = new int[N];

		for (int i = 0; i < N; i++) {
			oasis[i] = Integer.parseInt(br.readLine());
		}

		Stack<int[]> stack = new Stack<>();
		long count = 0; // 서로 볼 수 있는 쌍의 수

		for (int i = 0; i < N; i++) {
			int currentHeight = oasis[i];
			int currentCount = 1;

			// 현재 사람보다 작거나 같은 키를 가진 사람들을 스택에서 제거
			while (!stack.isEmpty() && stack.peek()[0] <= currentHeight) {
				int[] top = stack.pop();
				count += top[1];

				// 같은 키가 있는 경우, 현재 사람의 키와 같은 경우를 처리
				if (top[0] == currentHeight) {
					currentCount += top[1];
				}
			}

			// 스택이 비어있지 않다면, 스택의 top 요소는 현재 사람보다 키가 큼
			if (!stack.isEmpty()) {
				count++;
			}

			// 현재 사람을 스택에 추가
			stack.push(new int[] { currentHeight, currentCount });
		}

		System.out.println(count);
	}
}
