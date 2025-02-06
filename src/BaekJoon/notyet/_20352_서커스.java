package BaekJoon.notyet;

import java.util.Scanner;

public class _20352_서커스 {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();

		double r = Math.sqrt(a / Math.PI);

		double circle = 2 * Math.PI * r;

		System.out.printf("%.10f\n", circle);	

	}

}
