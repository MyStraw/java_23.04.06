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
	
	static void addMatrix(int[][], int[][], )
	
	

	public static void main(String[] args) {

		int[][] A = new int[2][3];
		int[][] A1 = new int[2][3];
		int[][] A2 = new int[2][3];
		int[][] B = new int[3][4];
		int[][] C = new int[2][4];
		int[][] D = new int[3][2];

	}

	static void randomMatrix(int[][] mat) {
		Random rand = new Random();
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 3; j++)
				mat[i][j] = rand.nextInt(10);	
	}
	
}
