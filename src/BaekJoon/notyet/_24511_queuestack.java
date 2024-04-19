package BaekJoon.notyet;

import java.util.Scanner;

//배열 형태로 풀이. 모든 스택과 큐를 쓰는건 비효율적이다. 10만개의 큐랑 스택구현을 못해.
	//클래스로 큐와 스택에서 쓰이는 각각 add, poll 과 push, pop만 직접 구현을 해서 쓰면 좋을거라고 생각했다.
	//그런데 gpt는 더 나아가서 클래스 내에 type을 구분하는 코드를 넣었다. 이러면 굳이 pop과 poll을 구분할 필요가 없지.

public class _24511_queuestack { 

	static class QueueStack {
		int type; // 0 for Queue, 1 for Stack
		int value; // Current value in the QueueStack

		public QueueStack(int type, int value) {
			this.type = type;
			this.value = value;
		}

		public int insertAndRemove(int newValue) {
			if (this.type == 0) { // Queue behavior
				int oldValue = this.value;
				this.value = newValue;
				return oldValue;
			} else { // Stack behavior
				return newValue;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		QueueStack[] queueStacks = new QueueStack[N];

		for (int i = 0; i < N; i++) {
			int type = sc.nextInt();
			queueStacks[i] = new QueueStack(type, 0); // Initialize with dummy value
		}

		for (int i = 0; i < N; i++) {
			int initialValue = sc.nextInt();
			queueStacks[i].value = initialValue; // Set the initial value
		}

		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int C = sc.nextInt();
			for (QueueStack qs : queueStacks) {
				C = qs.insertAndRemove(C);
			}
			System.out.print(C + " ");
		}
		sc.close();
	}
}
