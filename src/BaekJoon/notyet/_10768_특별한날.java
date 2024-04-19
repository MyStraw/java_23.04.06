package BaekJoon.notyet;

import java.util.Scanner;

public class _10768_특별한날 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int d = sc.nextInt();

		if (m > 2) {
			System.out.println("After");
		} else if (m < 2) {
			System.out.println("Before");
		} else if (m == 2) {
			if (d > 18) {
				System.out.println("After");
			} else if (d < 18) {
				System.out.println("Before");
			} else {
				System.out.println("Special");
			}

		}
	}
}
