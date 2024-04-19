package BaekJoon.notyet;

import java.util.Scanner;

public class _11653_소인수분해 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 2; i <= N; i++) {
			while (N % i == 0) {
				System.out.println(i);
				N = N / i;
			}
		}
	}
}
