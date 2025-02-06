package BaekJoon.notyet;

import java.util.Scanner;

public class _20233_Bicycle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int x = sc.nextInt();
		int b = sc.nextInt();
		int y = sc.nextInt();
		int T = sc.nextInt();

		int cost1 = a;
		if (T > 30) {
			cost1 += (T - 30) * x * 21;
		}

		int cost2 = b;
		if (T > 45) {
			cost2 += (T - 45) * y * 21;
		}

		System.out.println(cost1 + " " + cost2);

	}

}
