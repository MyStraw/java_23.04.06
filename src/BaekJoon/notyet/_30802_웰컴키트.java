package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _30802_웰컴키트 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size[] = new int[6];
		for (int i = 0; i < 6; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int clothCount = 0;
		for (int i = 0; i < 6; i++) {
			 clothCount += (size[i] + T - 1) / T;
		}
		System.out.println(clothCount);

		System.out.print(N / P + " " + N % P);

	}

}
