package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _7_문제_11279_최대힙 {

	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	static void buildHeap(int[] arr) {
		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
	}

	static void heapify(int[] arr, int n, int i) {
		int largest = i; // 부모 노드
		int left = 2 * i + 1; // 왼쪽 자식 노드
		int right = 2 * i + 2; // 오른쪽 자식 노드

		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}
		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}
		if (largest != i) {
			swap(arr, i, largest);
			heapify(arr, n, largest);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int calculation[] = new int[N];
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) {
				array.add(x);
			}
		}
		int[] heap = new int[array.size()];
		for (int i = 0; i < array.size(); i++) {
			heap[i] = array.get(i); // 자동 언박싱
		}
		// Arrays.fill(heap, -1); // 좋은데? 배열 초기화 해주는 메소드
		buildHeap(heap);
		// ----------------------여기까지가 힙 정렬 세팅 O(N)
		// 하나씩 요소를 꺼내어 정렬을 수행
		int n = heap.length;
		for (int i = array.size() - 1; i > 0; i--) {
			// 루트를 배열의 마지막 요소와 교환
			swap(heap, 0, i);
			if (heap[i] == 0)
				System.out.println(heap[i]);
			// 힙의 크기를 줄이고, 힙 속성을 다시 맞춤
			heapify(heap, i, 0);
		}

		// 정렬된 배열 출력
		for (int i = 0; i < n; i++) {
			System.out.print(heap[i] + " ");
		}
	}

}
