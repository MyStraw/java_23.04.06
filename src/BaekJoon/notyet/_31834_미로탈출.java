package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _31834_미로탈출 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			if (N == 2 || (S == 1 && E == N) || (S == N && E == 1)) {
				System.out.println(0);
			} else if (S + 1 == E || S == E + 1 || (S == 1 && E != S + 1) || (S == N && E != S - 1)) {
				System.out.println(1);
			} else {
				System.out.println(2);
			}
		}
	}
}
