package BaekJoon.notyet;

import java.util.Scanner;

public class _23235_The_Fastest_Sorting_Algorithm_In_The_World {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int test = 1;
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;

			for (int i = 0; i < n; i++) {
				sc.nextInt();
			}

			System.out.println("Case " + test + ": Sorting... done!");
			test++;
		}
	}
}
