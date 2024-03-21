package BaekJoon;

import java.util.Scanner;

public class _6763_Speed2 {
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
		int overSpeed = recorded - limit;

		if (overSpeed >= 31) {
			return 500;
		} else if (overSpeed >= 21) {
			return 270;
		} else if (overSpeed >= 1) {
			return 100;
		} else {
			return 0;
		}
	}
}
