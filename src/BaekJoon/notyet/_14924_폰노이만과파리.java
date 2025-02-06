package BaekJoon.notyet;

import java.util.Scanner;

public class _14924_폰노이만과파리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int S = sc.nextInt();
		int T = sc.nextInt();
		int D = sc.nextInt();

		int F = (D / (2 * S)) * T;

		System.out.println(F);

	}

}
