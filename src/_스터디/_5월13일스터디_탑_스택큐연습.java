package _스터디;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _5월13일스터디_탑_스택큐연습 {

	public static void main(String[] args) {
			
		Stack st = new Stack();
		Queue q = new LinkedList();

		st.push("0"); // 스택에 넣을때
		st.push("1");
		st.push("2");

		q.offer("0"); // 큐에 넣을때
		q.offer("1");
		q.offer("2");

		System.out.println("= Stack =");
		while (!st.empty()) { // 스택이 비어있는지 확인
			System.out.println(st.pop()); // 스택에서 꺼낼때
		}

		System.out.println("= Queue =");
		while (!q.isEmpty()) { // 큐가 비었는지 확인
			System.out.println(q.poll()); // 큐에서 꺼낼때
		}
	}

}
