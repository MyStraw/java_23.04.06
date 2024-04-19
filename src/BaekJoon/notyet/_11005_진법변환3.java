package BaekJoon.notyet;

import java.util.Scanner;

public class _11005_진법변환3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int B = sc.nextInt();

		StringBuilder ten = new StringBuilder();
		extracted(N, B, ten);

		while (N / B != 0) {
			N = N / B;
			extracted(N, B, ten);
		}

		System.out.println(ten.reverse());
	}

	private static void extracted(int N, int B, StringBuilder ten) {
		if (N % B >= 0 && N % B <= 9) {
			ten.append(N % B);
		} else {
			ten.append((char) (N % B + 'A' - 10));
		}
	}
}
