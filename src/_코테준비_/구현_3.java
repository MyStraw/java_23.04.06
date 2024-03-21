package _코테준비_;

import java.util.Scanner;

public class 구현_3 {

	public static void rotate(int[][] matrix) {
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

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[][] matrix = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}

		rotate(matrix);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		scanner.close();
	}

}

//문제 설명
//입력으로 N x N 크기의 행렬이 주어집니다. 이 행렬을 90도 회전한 결과를 출력하세요.
//입력 형식
//첫 번째 줄에 행렬의 크기 N이 주어집니다. (1 <= N <= 100)
//다음 N 줄에 걸쳐 행렬의 각 행에 해당하는 N개의 정수가 주어집니다. (행렬의 각 요소는 0 이상 100 이하의 정수)
//출력 형식
//N x N 크기의 90도 회전한 행렬을 출력하세요. 각 요소는 공백으로 구분하여 출력합니다.

//3
//1 2 3
//4 5 6
//7 8 9


//7 4 1 
//8 5 2 
//9 6 3 
