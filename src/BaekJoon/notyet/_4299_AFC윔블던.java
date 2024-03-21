package BaekJoon.notyet;

import java.util.Scanner;

public class _4299_AFC윔블던 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sum = sc.nextInt();
		int minus = sc.nextInt();
		int A = (sum + minus) / 2;
		int B = sum - A;

		if (A >= 0 && B >= 0 && A - B == minus && A + B == sum) {			
			System.out.println(Math.max(A, B) + " " + Math.min(A, B));
		} else {			
			System.out.println(-1);
		}
	}
}
