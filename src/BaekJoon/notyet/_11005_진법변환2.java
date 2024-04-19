package BaekJoon.notyet;

import java.util.Scanner;
import java.util.Stack;

public class _11005_진법변환2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int B = sc.nextInt();

		Stack<Integer> ten = new Stack<>();
		ten.add(N % B);

		while (N / B != 0) {
			N = N / B;
			ten.add(N % B);
		}
		int length = ten.size();

		for (int i = 0; i < length; i++) {
			if (ten.peek() >= 0 && ten.peek() <= 9) {
				System.out.print(ten.pop());
			} else {
				System.out.print((char)(ten.pop() + 'A' - 10));
			}
		}
	}
}
