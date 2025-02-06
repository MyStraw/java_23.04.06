package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _11688_최소공배수찾기 {
	public static long gcd(long x, long y) {
		while (y != 0) {
			long temp = y;
			y = x % y;
			x = temp;
		}
		return x;
	}

	public static long lcm(long x, long y) {
		return (x * y) / gcd(x, y);
	}

	public static List<Long> yaksu(long n) {
		List<Long> yaksu = new ArrayList<>();
		for (long i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				yaksu.add(i);
				if (i != n / i) {
					yaksu.add(n / i);
				}
			}
		}
		Collections.sort(yaksu);
		return yaksu;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long L = Long.parseLong(st.nextToken());

		long abLcm = lcm(a, b);

		if (abLcm == L) {
			System.out.println(1);
		} else if (L % abLcm != 0) {
			System.out.println(-1);
		} else {
			List<Long> yaksu = yaksu(L);
			for (long c : yaksu) {
				if (lcm(abLcm, c) == L) {
					System.out.println(c);
					break;
				}
			}
		}
	}

}
