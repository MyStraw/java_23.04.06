package BaekJoon.notyet;

import java.util.Scanner;

public class _6888_Terms_of_Office {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();
		int Y = sc.nextInt();

		int change = X;

		while (change <= Y) {
			System.out.println("All positions change in year " + change);
			change += 60;
		}

	}

}
