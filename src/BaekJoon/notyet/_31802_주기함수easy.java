package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _31802_주기함수easy {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long p, a, b, q, res = 0, sum = 0;
		p = Long.parseLong(br.readLine());

		long[] arr = new long[(int) p];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < p; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			sum += arr[i];
		}

		st = new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());

		q = (b - a) / p;
		b -= q * p;
		res += q * sum;

		if (a < 0) {
			q = (-a + p - 1) / p;
			a += q * p;
			b += q * p;
		}

		for (long i = a; i <= b - 1; i++) {
			res += arr[(int) (i % p)];
		}

		System.out.println(res);
	}

}
