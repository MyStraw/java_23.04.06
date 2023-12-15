package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1024_수열의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		for (int i = 1; i < 500000000; i++) {
			int result = 0;
			int count = 0;
			for (int j = i; j <= i + 100; j++) {
				result += j;
				count++;
				if (result == N) {
					if (count >= L) {
						System.out.println();
						break;
					} else if (count < L || count > 100) {
						System.out.println("-1");
						break;
					}
				} else if (i == 499999999 && j == i + 100 && result != N) {
					System.out.println("-1");
				}
			}
		}

	}
}
