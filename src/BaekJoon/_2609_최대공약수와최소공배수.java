package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2609_최대공약수와최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int max = 0;
		int min = 0;

		if (A >= B) {
			max = A;
			min = B;
		}
		if (B > A) {
			max = B;
			min = A;
		}

		System.out.println(gcd(max, min));
		System.out.println(lcm(max, min));
	}

	public static int gcd(int max, int min) {
		while (min != 0) {

			int rem = max % min; // 나머지 구하고
			max = min; // 작은값을 큰값에 대입
			min = rem; // 나머지 값을 작은값에 대입
		}

		return max; // max가 최대공약수
	}

	public static int lcm(int max, int min) {
		return max * min / gcd(max, min);
	}

}