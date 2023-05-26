package _스터디;

import java.util.Scanner;

public class 재귀잉 {
	static int[][] Z;
	static int count = -1;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int N = 1 << n;
		int r = in.nextInt();
		int c = in.nextInt();
		Z = new int[N][N];
		star(0, 0, N);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(Z[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);

		System.out.println(Z[r][c]);
	}

	static void star(int x, int y, int N) {
		if (N == 1) {
			count++;
			Z[x][y] = count;
			return;
		}

		int size = N / 2;
//		int count = 0; //어라라? 이게 더 복잡하네~? 결국 2X2 도는거잖아~
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
//				count++;
				star(i, j, size);
			}
		}
	}
}