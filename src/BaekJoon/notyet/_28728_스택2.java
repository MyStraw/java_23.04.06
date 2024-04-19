package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _28728_스택2 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		//IntStack stack = new IntStack(N); //내부클래스에 static 붙이면 이걸로.
		IntStack stack = new _28728_스택2().new IntStack(N); //내부클래스에 static 없애려면 이렇게.
		while (N-- > 0) {
			String[] order = br.readLine().split(" ");
			int X;

			switch (order[0]) {
			case "1":
				X = Integer.parseInt(order[1]);
				stack.push(X);
				break;

			case "2":
				bw.write(String.valueOf(stack.pop()) + "\n");
				break;

			case "3":
				bw.write(String.valueOf(stack.size()) + "\n");
				break;

			case "4":
				bw.write(String.valueOf(stack.empty()) + "\n");
				break;

			case "5":
				bw.write(String.valueOf(stack.peek()) + "\n");
				break;
			}
		}
		bw.flush();
		bw.close();
	}

	private class IntStack {
		private int volume;
		private int point;
		private int stack[];

		private IntStack(int N) {
			point = 0;
			volume = N;
			stack = new int[N];
		}

		private int push(int X) {//push를 하고 point를 다음 빈 배열로 미리 옮겨놓는다.
			stack[point] = X;
			return stack[point++];
		}

		private int pop() {
			if (point <= 0) {
				return -1;
			}
			return stack[--point];
		}

		private int size() { //point는 인덱스니까 0부터 시작. -1 할 필요가 없다.
			return point;
		}

		private int empty() {
			if (point <= 0) {
				return 1;
			}
			return 0;
		}

		private int peek() {
			if (point > 0) {
				return stack[point - 1];
			}
			return -1;
		}
	}
}