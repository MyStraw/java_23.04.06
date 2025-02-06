package BaekJoon.notyet;

import java.util.Scanner;

public class _16715_inspiration {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int maxSum = -1;
		int bestBase = -1;

		for (int base = 2; base <= N; base++) {
			int currentSum = Sum(N, base);
			if (currentSum > maxSum) {
				maxSum = currentSum;
				bestBase = base;
			} else if (currentSum == maxSum && base < bestBase) {
				bestBase = base;
			}
		}

		System.out.println(maxSum + " " + bestBase);
	}

	public static int Sum(int n, int base) {
		int sum = 0;
		while (n > 0) {
			sum += n % base;
			n /= base;
		}
		return sum;
	}

}
