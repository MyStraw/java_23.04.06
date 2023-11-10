package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _5_문제_24056_알고리즘수업_삽입정렬6_3 {

	static boolean sameSame(int[] A, int[] B, int dataSize) {
		for (int i = 0; i < dataSize; i++) {
			if (A[i] != B[i]) {
				return false;
			}
		}
		return true;
	}

	static int insertionSort(int[] A, int[] B, int dataSize) {

		for (int i = 0; i < dataSize; i++) { // 맨 왼쪽은 정렬이 끝났다고 가정
			if (sameSame(A, B, dataSize)) {
				return 1;
			}
			int j;
			int temp = A[i];
			for (j = i; j > 0 && A[j - 1] > temp; j--) {
				A[j] = A[j - 1]; // 복사 =>즉 이걸 이동으로 치네. 복사연산이 들어간다.
				if (sameSame(A, B, dataSize)) {
					return 1;
				}
			}
			A[j] = temp;
		}
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

		for (int i = 0; i < dataSize; i++) {
			A[i] = Integer.parseInt(aToken.nextToken());
			B[i] = Integer.parseInt(bToken.nextToken());
//			System.out.print(A[i] + " ");
//			System.out.println(B[i]);
		}
		bw.write(String.valueOf(insertionSort(A, B, dataSize)));
		bw.flush();
		bw.close();

		
	}
}
