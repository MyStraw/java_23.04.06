package _백준대회.INU2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D_마법의나침반 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		boolean[][] possible = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(possible[i], true);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			for (int a = 1; a <= N; a++) {
				for (int b = 1; b <= N; b++) {
					if (a == x && b == y) {
						possible[a][b] = false;
						continue;
					}

					boolean keep = false;
					switch (k) {
					case 1:
						keep = (a < x && b == y);
						break;
					case 2:
						keep = (a < x && b > y);
						break;
					case 3:
						keep = (a == x && b > y);
						break;
					case 4:
						keep = (a > x && b > y);
						break;
					case 5:
						keep = (a > x && b == y);
						break;
					case 6:
						keep = (a > x && b < y);
						break;
					case 7:
						keep = (a == x && b < y);
						break;
					case 8:
						keep = (a < x && b < y);
						break;
					}

					if (!keep) {
						possible[a][b] = false;
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (possible[i][j]) {
					System.out.println(i + " " + j);
					return;
				}
			}
		}
	}
}
