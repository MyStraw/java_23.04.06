package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _18258_큐2_1 {
	private static class IntQueue {
		private int volume;
		private int point;
		private int que[];

		private IntQueue(int N) {
			volume = N;
			point = 0;
			que = new int[N + 1];
		}

		int push(int X) {
			que[point] = X;
			return que[point++];
		}

		int pop() { // 실제로 삭제하는 로직은 안넣는다. point 위치만 이동시킬뿐. 성능측면에서 이거 더 낫다.
			// push할때 그냥 덮어씌우는 개념이다.
			if (point <= 0) {
				return -1;
			}
			int front = que[0];
			if (point >= 1) {				
				for (int i = 0; i < point-1; i++) {
					que[i] = que[i + 1];
				}
				point--;
			}
			return front;
		}

		int size() {
			return point;

		}

		int empty() { //이거랑 front를 point가 아닌 que.length를 해버려서 배열 인덱스 오류가 났다.
			if (point == 0) {
				return 1;
			}
			return 0;
		}

		int front() {
			if (point <= 0) {
				return -1;
			}
			return que[0];

		}

		int back() {
			if (point <= 0) {
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
