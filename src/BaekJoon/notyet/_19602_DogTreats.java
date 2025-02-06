package BaekJoon.notyet;

import java.util.Scanner;

public class _19602_DogTreats {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();

		int total = S + 2 * M + 3 * L;

		if (total >= 10) {
			System.out.println("happy");
		} else {
			System.out.println("sad");
		}

	}

}
