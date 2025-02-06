package BaekJoon.notyet;

import java.math.BigInteger;
import java.util.Scanner;

public class _16565_N포커2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(fourCard(N));
	}

	public static BigInteger fourCard(int N) {
		BigInteger MOD = BigInteger.valueOf(10007);
		BigInteger total = BigInteger.ZERO;
		int set = N / 4;

		BigInteger jungbok = BigInteger.ZERO;
		for (int i = 1; i <= set; i++) {
			jungbok = combination(13, i).multiply(combination(52 - 4 * i, N - 4 * i));
			if (i % 2 == 1) {
				total = total.add(jungbok);
			} else {
				total = total.subtract(jungbok);
			}
		}
		return total.mod(MOD);

	}

	public static BigInteger combination(int x, int y) {
		if (y > x) {
			return BigInteger.ZERO;
		}

		if (y == 0 || x == y) {
			return BigInteger.ONE;
		}

		BigInteger ja = factorial(x);
		BigInteger mo = factorial(y).multiply(factorial(x - y));
		return ja.divide(mo);

	}

	public static BigInteger factorial(int N) {
		if (N == 0) {
			return BigInteger.ONE;
		}
		BigInteger result = BigInteger.ONE;
		for (int i = 1; i <= N; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}

}