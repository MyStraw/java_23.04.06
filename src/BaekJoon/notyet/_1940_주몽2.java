package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1940_주몽2 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int joomong[] = new int[N];
		for (int i = 0; i < N; i++) {
			joomong[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(joomong);

		int count = 0;
		int start = 0;
		int end = joomong.length - 1;

		while (start < end) {
			int sum = joomong[start] + joomong[end];

			if (sum == M) {
				count++;
				start++;
				end--;
			} else if (sum < M) {
				start++;
			} else {
				end--;
			}
		}
		System.out.println(count);
	}
}
