package _스터디;

import java.util.Scanner;

public class _5월20일_별찍기2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		extracted(N);
	}
	
	private static char extracted(int N) {
		char top[][] = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!(i == j && i == 1))
					top[i][j] = '*';
				System.out.print(top[i][j]);
			}
			System.out.println();
		}
		return 0;
	}
}
