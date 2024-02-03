package BaekJoon.notyet;

import java.util.Scanner;

public class _1110_더하기사이클 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int origin = N;
		int cycle = 0;

		do {
			int ten = N / 10;
			int one = N % 10;
			int sum = ten + one;
			N = (one * 10) + (sum % 10);
			cycle++;

		} while (N != origin);

		System.out.println(cycle);
	}
}