package BaekJoon.notyet;

import java.util.Scanner;

public class _31798_단원평가 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double a = sc.nextInt();
		double b = sc.nextInt();
		double c = sc.nextInt();

		if (a == 0) {
			a = c * c - b;
			System.out.println((int) a);
		} else if (b == 0) {
			b = c * c - a;
			System.out.println((int) b);
		} else if (c == 0) {
			c = Math.sqrt(a + b);
			System.out.println((int) c);
		}

	}

}
