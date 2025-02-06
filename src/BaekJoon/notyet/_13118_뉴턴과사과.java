package BaekJoon.notyet;

import java.util.Scanner;

public class _13118_뉴턴과사과 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] position = new int[4];
		for (int i = 0; i < 4; i++) {
			position[i] = scanner.nextInt();
		}

		int appleX = scanner.nextInt();
		int appleY = scanner.nextInt();
		int appleR = scanner.nextInt();

		int person = 0;
		for (int i = 0; i < 4; i++) {
			if (appleX == position[i]) {
				person = i + 1;
				break;
			}
		}

		System.out.println(person);
	
	}

}
