package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _7_문제_24173_알고리즘수업_힙정렬2 {
	public static int count = 0;
	public static int K = 0;

	static void swap(int[] a, int idx1, int idx2) {
		count++;
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
		if (K == count) {
			String result = Arrays.stream(a) // 배열을 스트림으로 변환
					.mapToObj(String::valueOf) // int를 String으로 변환
					.collect(Collectors.joining(" ")); // 공백으로 구분해 합치기
			System.out.println(result);
		}
	}

	// 배열을 최대 힙으로 구성하는 메소드
	static void buildHeap(int[] arr) {
		int n = arr.length;

		// 마지막 부모 노드부터 시작하여 루트 노드까지 반복
		for (int i = n / 2 - 1; i >= 0; i--) { // 책에는 (i-1)/2
			heapify(arr, n, i);
		}
	}

	// 힙 상태를 계속 유지
	static void heapify(int[] arr, int n, int i) {
		int smallest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && arr[left] < arr[smallest]) {
			smallest = left;
		}

		if (right < n && arr[right] < arr[smallest]) {
			smallest = right;
		}

		if (smallest != i) {
			swap(arr, i, smallest);
			// 재귀적로 하위 트리
			heapify(arr, n, smallest);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int bae[] = new int[A];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			bae[i] = Integer.parseInt(st.nextToken());
		}

		buildHeap(bae);
		int n = bae.length;

		for (int i = n - 1; i > 0; i--) {

			swap(bae, 0, i);
			heapify(bae, i, 0);
		}

		if (K > count) {
			System.out.println("-1");
		}
	}

}
