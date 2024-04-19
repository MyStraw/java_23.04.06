package BaekJoon.notyet;

import java.util.Scanner;

public class _2525_오븐시계 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		if (0 <= A && A <= 23 && 0 <= B && B <= 59 && 0 <= C && C <= 1000) {
			if (A + (B + C) / 60 > 23) {
				A += (B + C) / 60 - 24;
				B = (B + C) % 60;
				System.out.println(A + " " + B);

			} else if (A + (B + C) / 60 <= 23) {
				A += (B + C) / 60;
				B = (B + C) % 60;
				System.out.println(A + " " + B);
			}
		}
	}
}