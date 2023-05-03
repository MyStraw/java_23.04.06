package Chap2_기본자료구조;

import java.util.Random;

//3. 행렬문제

//A[2][3], A1[2][3], A2[2][3] A2=A+A1 //더하기
//B[3][4] C=AXB //곱하기
//C[2][4] 
//D=A의 전치행렬(row와 column을 바꾸어 저장)//전치행렬
//D[3][2]

//A,A1,B는 showData(A), 난수생성입력, showData(B)로 빼놓기
//addMatrix(A,A1,A2)
//A2 = A+A1
//multiplyMatrix (A,B,C)
//C = AXB
//transposeMatrix(A,D)

//전치행렬이란
//A{123}   D{1 4}
// {456}    {2 5}
//	     	{3 6}  

public class _02행렬문제 {

	static void addMatrix(int[][] m1, int[][] m2, int r, int c, int[][] mR) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				mR[i][j] = m1[i][j] + m2[i][j];
			}
		}
	}

	static void multiplyMatrix(int[][] m1, int[][] m2, int r1, int c2, int c1r2, int[][] mR) {
		for (int i = 0; i < r1; i++) {
			for (int j = 0; j < c1r2; j++) {
				int sum = 0;
				for (int k = 0; k < c2; k++) {
					sum += m1[i][k] * m2[k][j];
				}
				mR[i][j] = sum;
			}
		}
	}

	static void transposeMatrix(int[][] m, int[][] mR, int r, int c) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				mR[j][i] = m[i][j];
			}
		}
	}

	public static void main(String[] args) {

		int[][] A = new int[2][3];
		int[][] A1 = new int[2][3];
		int[][] A2 = new int[2][3];
		int[][] B = new int[3][4];
		int[][] C = new int[2][4];
		int[][] D = new int[3][2];

		randomMatrix(A, 2, 3);
		randomMatrix(A1, 2, 3);
		randomMatrix(B, 3, 4); // 1)여기까지 A, A1, B 할당!!

		System.out.println("A 행렬");
		showMatrix(A, 2, 3);
		System.out.println("------------------------");

		System.out.println("A1 행렬");
		showMatrix(A1, 2, 3);
		System.out.println("------------------------");

		System.out.println("B 행렬");
		showMatrix(B, 3, 4);
		System.out.println("------------------------");

		System.out.println("A2(더하기) 행렬");
		addMatrix(A, A1, 2, 3, A2);
		showMatrix(A2, 2, 3);
		System.out.println("------------------------");

		System.out.println("C(곱) 행렬");
		multiplyMatrix(A, B, 2, 3, 2, C);
		showMatrix(C, 2, 4);
		System.out.println("------------------------");

		System.out.println("D(전치) 행렬");
		transposeMatrix(A, D, 2, 3);
		showMatrix(D, 3, 2);
		System.out.println("------------------------");

	}

	static void randomMatrix(int[][] mat, int r, int c) {// 받아 쓰자.
		Random rand = new Random();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				mat[i][j] = rand.nextInt(10);
			}
		}
	}

	static void showMatrix(int[][] mat, int r, int c) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
