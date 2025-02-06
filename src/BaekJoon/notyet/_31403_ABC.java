package BaekJoon.notyet;

import java.util.Scanner;

public class _31403_ABC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		System.out.println(A + B - C);

		String plus = String.valueOf(A) + String.valueOf(B);
		int stringResult = Integer.parseInt(plus) - Integer.parseInt(String.valueOf(C));

		System.out.println(stringResult);

	}

}
