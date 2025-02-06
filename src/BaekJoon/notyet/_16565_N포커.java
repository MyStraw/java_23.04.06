package BaekJoon.notyet;

import java.math.BigInteger;
import java.util.Scanner;

public class _16565_N포커 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	
		System.out.println(fourCard(N));

	}

	public static int fourCard(int N) {
		int MOD = 10007;

		if (N < 4) {
			return 0;
		} else if (4 <= N && N < 8) {
			return BigInteger.valueOf(13).multiply(combination(48, N - 4)).mod(BigInteger.valueOf(MOD)).intValue();
		} else if (8 <= N && N < 12) {
			return BigInteger.valueOf(13).multiply(combination(48, N - 4))
					.subtract(combination(13, 2).multiply(combination(44, N - 8))).mod(BigInteger.valueOf(MOD))
					.intValue();
		} else if (12 <= N && N < 16) {
			return BigInteger.valueOf(13).multiply(combination(48, N - 4))
					.subtract(combination(13, 2).multiply(combination(44, N - 8)))
					.add(combination(13, 3).multiply(combination(40, N - 12))).mod(BigInteger.valueOf(MOD)).intValue();
		} else if (16 <= N && N < 20) {
			return BigInteger.valueOf(13).multiply(combination(48, N - 4))
					.subtract(combination(13, 2).multiply(combination(44, N - 8)))
					.add(combination(13, 3).multiply(combination(40, N - 12)))
					.subtract(combination(13, 4).multiply(combination(36, N - 16))).mod(BigInteger.valueOf(MOD))
					.intValue();
		} else if (20 <= N && N < 24) {
			return BigInteger.valueOf(13).multiply(combination(48, N - 4))
					.subtract(combination(13, 2).multiply(combination(44, N - 8)))
					.add(combination(13, 3).multiply(combination(40, N - 12)))
					.subtract(combination(13, 4).multiply(combination(36, N - 16)))
					.add(combination(13, 5).multiply(combination(32, N - 20))).mod(BigInteger.valueOf(MOD)).intValue();
		} else if (24 <= N && N < 28) {
			return BigInteger.valueOf(13).multiply(combination(48, N - 4))
					.subtract(combination(13, 2).multiply(combination(44, N - 8)))
					.add(combination(13, 3).multiply(combination(40, N - 12)))
					.subtract(combination(13, 4).multiply(combination(36, N - 16)))
					.add(combination(13, 5).multiply(combination(32, N - 20)))
					.subtract(combination(13, 6).multiply(combination(28, N - 24))).mod(BigInteger.valueOf(MOD))
					.intValue();
		} else if (28 <= N && N < 32) {
			return BigInteger.valueOf(13).multiply(combination(48, N - 4))
					.subtract(combination(13, 2).multiply(combination(44, N - 8)))
					.add(combination(13, 3).multiply(combination(40, N - 12)))
					.subtract(combination(13, 4).multiply(combination(36, N - 16)))
					.add(combination(13, 5).multiply(combination(32, N - 20)))
					.subtract(combination(13, 6).multiply(combination(28, N - 24)))
					.add(combination(13, 7).multiply(combination(24, N - 28))).mod(BigInteger.valueOf(MOD)).intValue();
		} else if (32 <= N && N < 36) {
			return BigInteger.valueOf(13).multiply(combination(48, N - 4))
					.subtract(combination(13, 2).multiply(combination(44, N - 8)))
					.add(combination(13, 3).multiply(combination(40, N - 12)))
					.subtract(combination(13, 4).multiply(combination(36, N - 16)))
					.add(combination(13, 5).multiply(combination(32, N - 20)))
					.subtract(combination(13, 6).multiply(combination(28, N - 24)))
					.add(combination(13, 7).multiply(combination(24, N - 28)))
					.subtract(combination(13, 8).multiply(combination(20, N - 32))).mod(BigInteger.valueOf(MOD))
					.intValue();
		} else if (36 <= N && N < 40) {
			return BigInteger.valueOf(13).multiply(combination(48, N - 4))
					.subtract(combination(13, 2).multiply(combination(44, N - 8)))
					.add(combination(13, 3).multiply(combination(40, N - 12)))
					.subtract(combination(13, 4).multiply(combination(36, N - 16)))
					.add(combination(13, 5).multiply(combination(32, N - 20)))
					.subtract(combination(13, 6).multiply(combination(28, N - 24)))
					.add(combination(13, 7).multiply(combination(24, N - 28)))
					.subtract(combination(13, 8).multiply(combination(20, N - 32)))
					.add(combination(13, 9).multiply(combination(16, N - 36))).mod(BigInteger.valueOf(MOD)).intValue();
		} else {
			return combination(52, 52 - N).mod(BigInteger.valueOf(MOD)).intValue();
		}
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