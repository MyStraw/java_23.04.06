package BaekJoon.notyet;

import java.util.Scanner;

public class _2137_가장가까운분수 {
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int q = sc.nextInt();

		double target = (double) p / q;
		double minDif = Double.MAX_VALUE;
		int gaggaBunja = 0;
		int gaggaBunmo = 0;

		for (int i = 1; i <= 32767; i++) {
			int bunja = (int) Math.round(target * i);

			if (bunja < 1 || bunja >= i)
				continue;

			if (gcd(bunja, i) == 1) {
				double current = (double) bunja / i;
				double difference = Math.abs(current - target);

				if (difference < minDif && (bunja != p || i != q)) {
					minDif = difference;
					gaggaBunja = bunja;
					gaggaBunmo = i;
				}
			}
		}

		System.out.println(gaggaBunja + " " + gaggaBunmo);
	}

}
