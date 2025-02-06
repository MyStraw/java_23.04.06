package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _29715_비밀번호찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(BR.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(BR.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int pwCnt = 0, cnt = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(BR.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a != 0)
				pwCnt++;
			else
				cnt++;
		}

		n -= pwCnt;
		long result = 1;
		if (cnt > 0) {
			result *= comb(n, cnt) * fact(cnt);
		}
		n -= cnt;
		if (n > 0) {
			result *= perm(9 - (pwCnt + cnt), n);
		}

		System.out.println(result * x + ((result - 1) / 3) * y);
	}

	static long fact(int n) {
		long res = 1;
		for (int i = 2; i <= n; i++) {
			res *= i;
		}
		return res;
	}

	static long perm(int n, int r) {
		long res = 1;
		for (int i = 0; i < r; i++) {
			res *= (n - i);
		}
		return res;
	}

	static long comb(int n, int r) {
		if (r > n)
			return 0;
		return perm(n, r) / fact(r);
	}
}
