package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _11502_세개의소수문제 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		int[] testCases = new int[T];

		for (int i = 0; i < T; i++) {
			testCases[i] = Integer.parseInt(br.readLine());
		}

		boolean[] isPrime = new boolean[1000];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i * i < 1000; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j < 1000; j += i) {
					isPrime[j] = false;
				}
			}
		}

		List<Integer> primes = new ArrayList<>();
		for (int i = 2; i < 1000; i++) {
			if (isPrime[i]) {
				primes.add(i);
			}
		}

		for (int K : testCases) {
			boolean found = false;
			for (int i = 0; i < primes.size() && !found; i++) {
				for (int j = i; j < primes.size() && !found; j++) {
					for (int k = j; k < primes.size(); k++) {
						if (primes.get(i) + primes.get(j) + primes.get(k) == K) {
							int[] result = { primes.get(i), primes.get(j), primes.get(k) };
							Arrays.sort(result);
							bw.write(result[0] + " " + result[1] + " " + result[2]);
							bw.newLine();
							found = true;
							break;
						}
					}
				}
			}
			if (!found) {
				bw.write("0");
				bw.newLine();
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
