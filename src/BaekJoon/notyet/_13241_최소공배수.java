package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13241_최소공배수 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());

		long max = 0;
		long min = 0;

		if (A >= B) {
			max = A;
			min = B;
		} else if (B > A) {
			max = B;
			min = A;
		}

		System.out.println(lcm(max, min));
	}

	public static long gcd(long max, long min) {
		while (min != 0) {

			long remainder = max % min; // 나머지 먼저 구하고
			max = min; // 작 -> 큰
			min = remainder; // 나머지 -> 작
		}
		return max; // 최대공약수. 대!!!(max)
	}

	public static long lcm(long max, long min) {
		return max * min / gcd(max, min); // 큰작 곱하고 최대공약 나누고.
	}

}
