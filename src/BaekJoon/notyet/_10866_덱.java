package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10866_덱 {
	static int N;

	static class IntStack {
		private int[] stk;
		private int capacity;
		private int point;

		public IntStack(int maxLen) {
			point = 0;
			capacity = maxLen;
			try {
				stk = new int[capacity];

			} catch (OutOfMemoryError e) {
				capacity = 0;
			}
		}

		public int push(int x) {
			return stk[point++] = x;
		}

		public int pop() {
			if (point <= 0)
				return -1;
			return stk[--point];
		}

		public int size() {
			return point;
		}

		public int empty() {
			if (point == 0)
				return 1;
			return 0;
		}

		public int top() {
			if (point == 0) {
				return -1;
			}
			return stk[point-1];
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		IntStack intStack = new IntStack(N);

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
			} else if (order.equals("top")) {
				System.out.println(intStack.top());
			}
		}
	}

}
