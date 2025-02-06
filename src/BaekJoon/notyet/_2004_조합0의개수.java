package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2004_조합0의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long n = Long.parseLong(st.nextToken());
		long m = Long.parseLong(st.nextToken());

		long count2 = countFactors(n, 2) - countFactors(m, 2) - countFactors(n - m, 2);
		long count5 = countFactors(n, 5) - countFactors(m, 5) - countFactors(n - m, 5);

		System.out.println(Math.min(count2, count5));
	}

	private static long countFactors(long num, int factor) {
		long count = 0;
		while (num >= factor) {
			count += num / factor;
			num /= factor;
		}
		return count;
	}

}
