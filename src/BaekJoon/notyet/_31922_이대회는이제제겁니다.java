package BaekJoon.notyet;

import java.util.Scanner;

public class _31922_이대회는이제제겁니다 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int P = sc.nextInt();
		int C = sc.nextInt();

		System.out.println(Math.max(A + C, P));

	}

}
