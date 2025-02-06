package _백준대회.선린제2회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B번_수열의비밀Easy {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int a1 = Integer.parseInt(br.readLine());

		int[] a = new int[n + 1];
		a[1] = a1;

		int sum = a1;

		for (int i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				a[i] = p * a[i / 2] + q;
			} else {
				a[i] = r * a[i / 2] + s;
			}
			sum += a[i];
		}

		System.out.println(sum);
	}

}
