package _코테준비_;

import java.util.Scanner;

public class 구현_4 {

	public static void flipVertically(int[][] matrix) {
		int N = matrix.length;
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[N - 1 - i][j];
				matrix[N - 1 - i][j] = temp;
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

		flipVertically(matrix);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		scanner.close();
	}

}

/*
 * 3.행렬의 상하
 * 
 * 반전 문제 (상) 
 * 문제 설명: N x N 크기의 행렬이 주어졌을 때, 이 행렬을 상하로 반전시킨 결과를 출력하세요. 
 * 입력 형식: 첫 번째줄에 행렬의 크기 N이 주어집니다. 다음 N 줄에 걸쳐 행렬의 각 행에 해당하는 N개의 정수가 주어집니다. 
 * 출력 형식: 상하로 반전된 행렬을 출력하세요. 각 요소는 공백으로 구분하여 출력합니다.
 */
	
//	입력 예시
//	
//	3
//	1 2 3
//	4 5 6
//	7 8 9
//	
//	출력 예시
//	
//	7 8 9
//	4 5 6
//	1 2 3
//	