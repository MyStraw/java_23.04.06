package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5_문제_24056_알고리즘수업_삽입정렬6_2 {
	static int insertionSort(int[] A, int[] B, int dataSize) {
		boolean sameSame = Arrays.equals(A, B);
		for (int i = 0; i < dataSize; i++) { // 맨 왼쪽은 정렬이 끝났다고 가정
			if (sameSame) {
				return 1;
			}
			int j;
			int temp = A[i];
			for (j = i; j > 0 && A[j - 1] > temp; j--) {
				if (sameSame) {
					return 1;
				}
				A[j] = A[j - 1]; // 복사 =>즉 이걸 이동으로 치네. 복사연산이 들어간다.
				if (sameSame) {
					return 1;
				}
			}
			A[j] = temp;
			if (sameSame) {
				return 1;
			}
		}
		if (sameSame) {
			return 1;
		}
		else
			return 0;
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int dataSize = Integer.parseInt(st.nextToken());
		int[] A = new int[dataSize];
		int[] B = new int[dataSize];
		StringTokenizer aToken = new StringTokenizer(br.readLine());
		StringTokenizer bToken = new StringTokenizer(br.readLine());

		boolean atrue = false;
		boolean btrue = false;

		for (int i = 0; i < dataSize; i++) {
			A[i] = Integer.parseInt(aToken.nextToken());
			B[i] = Integer.parseInt(bToken.nextToken());
//			System.out.print(A[i] + " ");
//			System.out.println(B[i]);
		}

		System.out.println(insertionSort(A, B, dataSize));
	}
}
