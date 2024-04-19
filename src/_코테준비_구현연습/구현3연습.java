package _코테준비_구현연습;

import java.util.Scanner;

public class 구현3연습 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		Watch(matrix);// 180도 회전
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void Watch(int[][] matrix) {
		int N = matrix.length;
		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < N - i - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[N - 1 - j][i];
				matrix[N - 1 - j][i] = matrix[N - 1 - i][N - 1 - j];
				matrix[N - 1 - i][N - 1 - j] = matrix[j][N - 1 - i];
				matrix[j][N - 1 - i] = temp;
			}
		}
	}

	private static void ReverseWatch(int[][] matrix) {
		int N = matrix.length;
		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < N - i - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][N - 1 - i];
				matrix[j][N - 1 - i] = matrix[N - 1 - i][N - 1 - j];
				matrix[N - 1 - i][N - 1 - j] = matrix[N - 1 - j][i];
				matrix[N - 1 - j][i] = temp;
			}
		}
	}

	public static void upDown(int[][] matrix) {
		int N = matrix.length;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[N - 1 - i][j];
				matrix[N - 1 - i][j] = temp;
			}
		}
	}

	private static void leftRight(int[][] matrix) {
		int N = matrix.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N / 2; j++) { // (i, j) 위치의 요소와 (i, N-1-j) 위치의 요소를 교환
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][N - 1 - j];
				matrix[i][N - 1 - j] = temp;
			}
		}
	}
}