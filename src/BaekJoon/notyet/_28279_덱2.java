package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _28279_덱2 {

	private static class IntDeque { // 순환배열을 사용해야하네. 배열의 길이만큼 나눔! front + 1 % deq.length 이렇게.
		private int front;
		private int rear;
		private int deq[];
		private int count;

		IntDeque(int N) {
			front = 0;
			rear = 0;
			deq = new int[N];
			count = 0;
		}

		void addFirst(int X) {
			count++;
			deq[front] = X;
			front = (front - 1 + deq.length) % deq.length;
		}

		void addLast(int X) {
			count++;
			rear++;
			rear = rear % deq.length;
			deq[rear] = X;
		}

		int pollFirst() {
			if (rear - front == 0) {
				return -1;
			}
			count--;
			front++;
			front = front % deq.length;
			return deq[front];
		}

		int pollLast() {
			if (rear - front == 0) {
				return -1;
			}
			count--;
			int t = deq[rear];
			rear--;
			rear = (rear + deq.length) % deq.length;
			return t;
		}

		int size() {
			return count;
		}

		int isEmpty() {
			if (rear - front == 0) {
				return 1;
			}
			return 0;
		}

		int peekFirst() {
			if (rear - front == 0) {
				return -1;
			}
			int t = front + 1;
			t = t % deq.length;
			return deq[t];
		}

		int peekLast() {
			if (rear - front == 0) {
				return -1;
			}
			return deq[rear];
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		IntDeque deque = new IntDeque(N);
		for (int i = 0; i < N; i++) {
			String[] order = br.readLine().split(" ");

			int X;

			switch (order[0]) {
			case "1":
				X = Integer.parseInt(order[1]);
				deque.addFirst(X);
				break;

			case "2":
				X = Integer.parseInt(order[1]);
				deque.addLast(X);
				break;

			case "3":
				bw.write(String.valueOf(deque.pollFirst()) + "\n");
				break;

			case "4":
				bw.write(String.valueOf(deque.pollLast()) + "\n");
				break;

			case "5":
				bw.write(String.valueOf(deque.size()) + "\n");
				break;

			case "6":
				bw.write(String.valueOf(deque.isEmpty()) + "\n");
				break;

			case "7":
				bw.write(String.valueOf(deque.peekFirst()) + "\n");
				break;

			case "8":
				bw.write(String.valueOf(deque.peekLast()) + "\n");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
