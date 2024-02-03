package BaekJoon.notyet;

import java.util.Scanner;

public class _2167_2차원배열의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] array = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		
		int[][] sum = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				sum[i][j] = array[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
			}
		}
	
		int K = sc.nextInt();
		for (int a = 0; a < K; a++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

		
			int result = sum[x][y] - sum[i - 1][y] - sum[x][j - 1] + sum[i - 1][j - 1];
			System.out.println(result);
		}
	}

}
