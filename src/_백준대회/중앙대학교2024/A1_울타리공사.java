package _백준대회.중앙대학교2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1_울타리공사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int minX = 100;
		int minY = 100;
		int maxX = -100;
		int maxY = -100;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			if (a < minX) {
				minX = a;
			}
			if (b < minY) {
				minY = b;
			}
			if (c > maxX) {
				maxX = c;
			}
			if (d > maxY) {
				maxY = d;
			}

			int result = ((maxX - minX) + (maxY - minY)) * 2;
			System.out.println(result);

		}

	}

}
