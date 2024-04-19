package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _24511_queuestack3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 자료구조 개수 받공~
		int N = Integer.parseInt(br.readLine());

		// A 배열 입력. 큐인지 스택인지 구분하는 A
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// B 배열 입력. A의 자료구조가 갖고있는 초기값 넣기
		int[] B = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		// 삽입할 수열 개수
		int M = Integer.parseInt(br.readLine());

		// 삽입될 수열 목록 C
		int[] C = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			C[i] = Integer.parseInt(st.nextToken());
			int currentElement = C[i]; // 바로 삽입하자
			for (int j = 0; j < N; j++) {
				if (A[j] == 0) { // Queue의 경우
					int temp = B[j]; // 현재 자료구조에서 pop되어 나오는애
					B[j] = currentElement; // 새 원소를 넣기
					currentElement = temp; // pop된 원소가 다음 자료구조의 삽입으로.
				}
			}
			sb.append(currentElement + " ");
		}
		System.out.println(sb);
	}
}
