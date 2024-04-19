package BaekJoon.notyet;

import java.util.Scanner;

public class _10870_피보나치수5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int fibo[] = new int[n + 1];

		if (n == 0) {
			System.out.println(0);
		} else if (n == 1) {
			System.out.println(1);
		} else if (n >= 2) {
			System.out.println(fibona(fibo, 1, n));
		}

	}

	public static int fibona(int fibo[], int i, int n) {

		fibo[0] = 0;
		fibo[1] = 1;
		i++;
		fibo[i] = fibo[i - 1] + fibo[i - 2];

		if (i == n) {
			return fibo[i];
		}
		return fibona(fibo, i, n);
	}

}
