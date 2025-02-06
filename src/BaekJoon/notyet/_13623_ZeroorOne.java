package BaekJoon.notyet;

import java.util.Scanner;

public class _13623_ZeroorOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		char winner = win(A, B, C);
		System.out.println(winner);
	
	}

	public static char win(int A, int B, int C) {
		if (A == B && B == C) {
			return '*';
		} else if (A != B && A != C) {
			return 'A';
		} else if (B != A && B != C) {
			return 'B';
		} else if (C != A && C != B) {
			return 'C';
		} else {
			return '*';
		}
	}

}
