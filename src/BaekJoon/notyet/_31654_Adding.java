package BaekJoon.notyet;

import java.util.Scanner;

public class _31654_Adding {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		System.out.println(adding(A, B, C));
		
	}

	private static String adding(int a, int b, int c) {
		int result = a + b;
		if (c == result) {
			return "correct!";
		}
		return "wrong!";
	}
}
