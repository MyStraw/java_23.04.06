package _백준대회.서울사이버대학교2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D번_젓가락고르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		long k = Long.parseLong(st.nextToken());

		long[] a = new long[n];
		st = new StringTokenizer(br.readLine());

		long totalSticks = 0;
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(st.nextToken());
			totalSticks += a[i];
		}

		Arrays.sort(a);

		long maxPossiblePairs = 0;
		for (long sticks : a) {
			maxPossiblePairs += sticks / 2;
		}

		if (maxPossiblePairs < k) {
			System.out.println(-1);
			return;
		}

		long x = 2 * k;
		while (true) {
			if (checkPossible(x, k, a)) {
				System.out.println(x);
				break;
			}
			x++;
			if (x > totalSticks) {
				System.out.println(-1);
				break;
			}
		}
	}

	static boolean checkPossible(long pick, long k, long[] a) {
		if (pick < 2 * k)
			return false;

		long remaining = pick;
		for (int i = a.length - 1; i >= 0; i--) {
			remaining -= Math.min(a[i], (pick + 1) / 2);
		}

		return remaining <= 0;
	}

}
