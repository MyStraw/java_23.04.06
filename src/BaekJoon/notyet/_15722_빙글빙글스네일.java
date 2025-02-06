package BaekJoon.notyet;

import java.util.Scanner;

public class _15722_빙글빙글스네일 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] result = snail(n);
		System.out.println(result[0] + " " + result[1]);
	}

	public static int[] snail(int n) {
		if (n == 0)
			return new int[] { 0, 0 };

		int x = 0, y = 0;
		int direction = 0;
		int step = 1;
		int stepCount = 0;
		int moveCount = 0;

		for (int i = 0; i < n; i++) {
			switch (direction) {
			case 0:
				y++;
				break;
			case 1:
				x++;
				break;
			case 2:
				y--;
				break;
			case 3:
				x--;
				break;
			}

			moveCount++;
			if (moveCount == step) {
				direction = (direction + 1) % 4;
				moveCount = 0;
				stepCount++;
				if (stepCount == 2) {
					step++;
					stepCount = 0;
				}
			}
		}

		return new int[] { x, y };
	}

}
