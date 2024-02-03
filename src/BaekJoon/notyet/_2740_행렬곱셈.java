package BaekJoon.notyet;

import java.util.Scanner;

public class _2740_행렬곱셈 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 행렬 A의 크기 입력받기
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		
		sc.nextInt();
		int K = sc.nextInt();
		int[][] B = new int[M][K];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < K; j++) {
				B[i][j] = sc.nextInt();
			}
		}

	
		int[][] result = new int[N][K];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				for (int l = 0; l < M; l++) {
					result[i][j] += A[i][l] * B[l][j];
				}
			}
		}

			for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
