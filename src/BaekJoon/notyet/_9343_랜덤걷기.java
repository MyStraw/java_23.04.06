package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _9343_랜덤걷기 {
	static final int MOD = 1000000007;
	static long[] factorial;
	static long[] invFactorial;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int maxN = 0;
		int[] cases = new int[T];

		for (int i = 0; i < T; i++) {
			cases[i] = Integer.parseInt(br.readLine());
			maxN = Math.max(maxN, cases[i]);
		}

		precomputeFactorials(maxN);

		for (int n : cases) {
			long result = catalan(n);
			bw.write(result + "\n");
		}

		bw.flush();
		bw.close();
	}

	static void precomputeFactorials(int n) {
		factorial = new long[2 * n + 1];
		invFactorial = new long[2 * n + 1];

		factorial[0] = invFactorial[0] = 1;

		for (int i = 1; i <= 2 * n; i++) {
			factorial[i] = factorial[i - 1] * i % MOD;
		}

		invFactorial[2 * n] = modInverse(factorial[2 * n], MOD);

		for (int i = 2 * n - 1; i >= 1; i--) {
			invFactorial[i] = invFactorial[i + 1] * (i + 1) % MOD;
		}
	}

	static long modInverse(long a, int mod) {
		return power(a, mod - 2, mod);
	}

	static long power(long a, int exp, int mod) {
		long result = 1;
		while (exp > 0) {
			if ((exp & 1) == 1) {
				result = result * a % mod;
			}
			a = a * a % mod;
			exp >>= 1;
		}
		return result;
	}

	static long catalan(int n) {
		if (n == 0)
			return 1;
		long numerator = factorial[2 * n];
		long denominator = invFactorial[n + 1] * invFactorial[n] % MOD;
		return numerator * denominator % MOD;
	}

}
