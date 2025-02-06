package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _3015_오아시스재결합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] oasis = new int[N];

		for (int i = 0; i < N; i++) {
			oasis[i] = Integer.parseInt(br.readLine());
		}

		int result[] = new int[N];

		int count = 0;
		Stack<Integer> stack = new Stack<>();

		for (int i = N-1; i >=0; i--) {
			while (!stack.isEmpty() && stack.peek() <= oasis[i]) {
				stack.pop();
				count++;
			}
			if (stack.isEmpty()) {
				result[i] = -1;			

			} else {
				result[i] = stack.peek();
			}
			stack.push(oasis[i]);
			count++;
		}
		System.out.println(count);
		 for (int num : result) {
	            System.out.print(num + " ");
	        }
	}
}
