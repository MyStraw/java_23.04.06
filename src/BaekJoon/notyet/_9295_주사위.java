package BaekJoon.notyet;

import java.util.Scanner;

public class _9295_주사위 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int dice1 = sc.nextInt();
			int dice2 = sc.nextInt();
			int sum = dice1 + dice2;

			System.out.println("Case " + i + ": " + sum);
		}
	}

}
