package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _18258_큐2 {
	private static class IntQueue {
		private int front;
		private int point;
		private int que[];

		private IntQueue(int N) {
			point = 0;
			front = 0;
			que = new int[N];
		}

		int push(int X) {
			que[point] = X;
			return que[point++];
		}

		int pop() {
			if (point - front <= 0) {
				return -1;
			}
			return que[front++];
		}

		int size() {
			return point - front;
		}

		int empty() {
			if (point - front == 0) {
				return 1;
			}
			return 0;
		}

		int front() {
			if (point - front <= 0) {
				return -1;
			}
			return que[front];

		}

		int back() {
			if (point - front <= 0) {
				return -1;
			}
			return que[point - 1];
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		IntQueue que = new IntQueue(N);
		for (int i = 0; i < N; i++) {
			String order[] = br.readLine().split(" ");

			switch (order[0]) {
			case "push":
				int X = Integer.parseInt(order[1]);
				que.push(X);
				break;

			case "pop":
				bw.write(String.valueOf(que.pop()) + "\n");
				break;

			case "size":
				bw.write(String.valueOf(que.size()) + "\n");
				break;

			case "empty":
				bw.write(String.valueOf(que.empty()) + "\n");
				break;

			case "front":
				bw.write(String.valueOf(que.front()) + "\n");
				break;

			case "back":
				bw.write(String.valueOf(que.back()) + "\n");
				break;

			}
		}
		bw.flush();
		bw.close();
	}
}
