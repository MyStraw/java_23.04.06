package _스터디;

import java.util.Scanner;

public class _5월20일_별찍기제출용 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] top = new char[N][N];

		star(top, false, N, 0, 0); // 별 찍을거, 별 안찍을 공백, 따로따로 분리 = 불리언
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(top[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private static void star(char[][] top, boolean gong, int N, int x, int y) {
		if (gong) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					top[i][j] = ' ';
				}
			}
			return;
		}
		if (N == 1) {
			top[x][y] = '*';
			return;
		}

		int size = N / 3;
		int count = 0; // 5칸을 이동할때마다 gong이 true = 공백찍기
						// 그외 칸들은 *찍기.
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				count++;
				if (count == 5) {
					star(top, true, size, i, j);
				} else {
					star(top, false, size, i, j);
				}
			}
		}
	}
}