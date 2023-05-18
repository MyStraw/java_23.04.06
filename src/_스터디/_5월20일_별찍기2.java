package _스터디;

import java.util.Scanner;

public class _5월20일_별찍기2 {
	static Scanner sc = new Scanner(System.in);
	static int k = sc.nextInt();
	static double N = Math.pow(3, k);

	static void star() {
		for (int i = 0; i < 3; i++) {
			System.out.print("*");
		}
		System.out.println("");
		for (int j = 0; j < 3; j++) {
			if (j != 1)
				System.out.print("*");
			else
				System.out.print(" ");
		}
		System.out.println("");
		for (int i = 0; i < 3; i++) {
			System.out.print("*");
		}
	}

	public static void main(String[] args) {

		star();

	}

}
