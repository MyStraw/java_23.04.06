package BaekJoon.notyet;

import java.util.Scanner;

public class _1862_미터계 {
	public static void main(String[] args) {//9진수?
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();

		int real = 0;
		int nine = 1;

		while (m > 0) {
			int digit = m % 10;
			m /= 10;

			if (digit > 4) {
				digit -= 1;
			}

			real += digit * nine;
			nine *= 9;

		}

		System.out.println(real);

	}

}
