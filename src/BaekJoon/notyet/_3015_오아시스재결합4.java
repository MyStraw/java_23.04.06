package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _3015_오아시스재결합4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] oasis = new int[N];

		for (int i = 0; i < N; i++) {
			oasis[i] = Integer.parseInt(br.readLine());
		}

		Stack<Now> stack = new Stack<>(); // 현재 잡고있는 {애 , 애의 카운트}
		long totalCount = 0; // 개별 카운트를 따로 세서 합쳐보자

		for (int i = 0; i < N; i++) {
			int nowAe = oasis[i];// 현재 내가 잡고있는 애
			int nowCount = 1;// 지금 잡고있는애 카운트.

			//현재 사람의 키가 스택의 맨 위 사람의 키보다 크거나 같으면, 스택에서 꺼내고 그 사람과 현재 사람의 쌍 계산
			while (!stack.isEmpty() && stack.peek().nowPerson <= nowAe) {
				Now top = stack.pop();
				totalCount += top.nowCount; //스택에서 모든 사람을 처리하고, 최종적으로 볼수있는 쌍의 수를 계산
				//스택에서 꺼낸 사람의 키가 현재 사람의 키와 같다면, 현재 사람의 키와 같은 사람의 수를 카운트
				if (top.nowPerson == nowAe) { // 같은키 수 올리기
					nowCount += top.nowCount;
				}
			}
			//스택이 비어있지 않으면, 현재 사람과 스택의 맨위 사람은 볼수있음
			if (!stack.isEmpty()) {
				totalCount++;
			}
			//현재사람 추가
			stack.push(new Now(nowAe, nowCount));
		}
		System.out.println(totalCount); 

	}
}

class Now {
	int nowPerson;
	int nowCount;

	Now(int nowPerson, int nowCount) {
		this.nowPerson = nowPerson;
		this.nowCount = nowCount;
	}
}
