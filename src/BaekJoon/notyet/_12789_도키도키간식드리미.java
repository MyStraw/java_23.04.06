package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class _12789_도키도키간식드리미 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Queue<Integer> right = new LinkedList<>();
		Queue<Integer> left = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		int pass = 1;

		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean sad = false;

		for (int i = 0; i < N; i++) {
			right.add(Integer.parseInt(st.nextToken()));
		}

		int count = 0;
		while (left.size() != N) {
			if (!right.isEmpty()) {
				if (right.peek() == pass) {
					left.add(right.poll());
					pass++;
				} else if (!stack.isEmpty() && (right.peek() < stack.peek())) {
					stack.push(right.poll());
				} else if (stack.isEmpty() && right.peek() != pass) {
					stack.push(right.poll());
				}
			}
			if (!stack.isEmpty()) {
				if (stack.peek() == pass) {
					left.add(stack.pop());
					pass++;
				}
			}
			count++;
			if (count > 2 * N) {
				sad = true;
				System.out.println("Sad");
				break;
			}
		}
		if (!sad) {
			System.out.println("Nice");
		}
	}
}

//4
//4 2 1 3