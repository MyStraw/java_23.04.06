package BaekJoon.notyet;

import java.util.Scanner;

public class _4589_Gnome_Sequencing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		System.out.println("Gnomes:");
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if ((a < b && b < c) || (a > b && b > c)) {
				System.out.println("Ordered");
			} else {
				System.out.println("Unordered");
			}
		}

	}

}
