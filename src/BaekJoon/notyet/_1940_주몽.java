package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1940_주몽 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		// int M = br.read(); //이건 아스키 코드로 나온다

		StringTokenizer st = new StringTokenizer(br.readLine());
		int joomong[] = new int[N];
		for (int i = 0; i < N; i++) {
			joomong[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;
		for (int i = 0; i < joomong.length - 1; i++) {
			for (int j = i + 1; j < joomong.length; j++) {
				if (joomong[i] + joomong[j] == M) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
