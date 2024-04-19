package BaekJoon.notyet;

import java.util.Scanner;

public class _6763_Speed {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int limit = sc.nextInt();
		int recorded = sc.nextInt();
		int fine = speedLimit(limit, recorded);

		if (fine == 0) {
			System.out.println("Congratulations, you are within the speed limit!");
		} else {
			System.out.println("You are speeding and your fine is $" + fine + ".");
		}

	}

	private static int speedLimit(int limit, int recorded) {
		int limits = limit;
		int recordeds = recorded;

		if (recordeds - limits >= 1 && recordeds - limits <= 20) {
			return 100;
		} else if (recordeds - limits >= 21 && recordeds - limits <= 30) {
			return 270;
		} else if (recordeds - limits > 30) {
			return 500;
		} else {
			return 0;
		}
	}
}
