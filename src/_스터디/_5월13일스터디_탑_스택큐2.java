package _스터디;
//9

//10 6 7 4 5 2 3 1 9

import java.util.Scanner;
import java.util.Stack;

public class _5월13일스터디_탑_스택큐2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Stack<Integer> st = new Stack<Integer>();
		Stack<Integer> st2 = st;
		int[] arr = new int[N];
		int[] copy = new int[N];
		int[] stack = new int[N];
		int count = 0;

		for (int i = 0; i < N; i++) {
			int top = sc.nextInt();
			st.push(top);
		}
		for (int i = 0; i < N; i++) {
			if (!st.empty()) {
				int pop = st.pop();
				if (st.empty()) {
					arr[N - count] = 0;
					break;
				}
				int peek = st.peek();				
				if (peek < pop) {
					count++;
					arr[N - count] = N - count - 1;
				} else if (peek >= pop) {
					count++;
					arr[N - count] = N - count;
				}
			}
		}
		for (int top : arr) {
			System.out.print(top + " ");
		}
	}
}
