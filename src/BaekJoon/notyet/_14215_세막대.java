package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _14215_세막대 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] triangle = new int[3];

		for (int i = 0; i < 3; i++) {
			triangle[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(triangle);
		int onePlusTwo = triangle[0] + triangle[1];

		if (triangle[0] + triangle[1] > triangle[2]) {
			System.out.println(onePlusTwo + triangle[2]);
		} else {
			System.out.println(2 * onePlusTwo - 1);

		}

	}

}
