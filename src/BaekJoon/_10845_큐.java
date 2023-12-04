package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10845_큐 {
	static int N;

	static class IntQue {
		private int[] que;
		private int capacity;
		private int front; // 맨 처음 요소 커서
		private int rear; // 맨 끝 요소 커서
		private int num; // 현재 데이터 개수

		public IntQue(int i) {
			num = front = rear = 0;
			capacity = i;
			try {
				que = new int[capacity]; // 큐 본체용 배열을 생성
			} catch (OutOfMemoryError e) { // 생성할 수 없음
				capacity = 0;
			}
		}

		public int push(int x) {
			que[rear++] = x;
			num++;
			if (rear == capacity)
				rear = 0;
			return x;
		}

		public int pop() {
			if (num <= 0)
				return -1;
			int x = que[front++];
			num--;
			if (front == capacity)
				front = 0;
			return x;
		}

		public int size() {
			return num;
		}

		public int empty() {
			if (num == 0)
				return 1;
			return 0;
		}

		public int front() {
			if (num == 0) {
				return -1;
			}
			return que[front];
		}

		public int back() {
			if (num == 0) {
				return -1;
			}
			return que[rear - 1];
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		IntQue intStack = new IntQue(N);

		for (int i = 0; i < N; i++) {
			String order = br.readLine();
			if (order.startsWith("push")) {
				String[] command = order.split(" ");
				int num = Integer.parseInt(command[1]);
				intStack.push(num);
			} else if (order.equals("pop")) {
				System.out.println(intStack.pop());
			} else if (order.equals("size")) {
				System.out.println(intStack.size());
			} else if (order.equals("empty")) {
				System.out.println(intStack.empty());
			} else if (order.equals("front")) {
				System.out.println(intStack.front());
			} else if (order.equals("back")) {
				System.out.println(intStack.back());
			}

		}
	}

}
