package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _3015_오아시스재결합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] oasis = new int[N];

		Queue<Integer> que = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			oasis[i] = Integer.parseInt(br.readLine());
			que.add(oasis[i]);
		}

		int count = 0;

		for (int i = 0; i < N; i++) {
			Stack<Integer> stack = new Stack<>();
			stack.push(0);
			for (int j = i + 1; j < N; j++) {
				if (oasis[j] >= oasis[i] && i + 1 != j && stack.peek() <= oasis[i]) {
					count++;
					// System.out.println(i + " " + j);
				} else if (oasis[j] < oasis[i] && i + 1 != j && oasis[j] >= stack.peek()) {
					count++;
					// System.out.println(i + " " + j);
				}
				if (stack.peek() <= oasis[j]) {
					stack.push(oasis[j]);
				}
			}
		}
		System.out.println(N - 1 + count);
	}
}
