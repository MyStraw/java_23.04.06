package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _7_문제_11279_최대힙 {

	static void swap(ArrayList<Integer> arr, int idx1, int idx2) {
		int temp = arr.get(idx1);
		arr.set(idx1, arr.get(idx2));
		arr.set(idx2, temp);
	}

	static void buildHeap(ArrayList<Integer> arr) {
		int n = arr.size();

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
	}

	static void heapify(ArrayList<Integer> arr, int n, int i) {
		int largest = i; // 부모 노드
		int left = 2 * i + 1; // 왼쪽 자식 노드
		int right = 2 * i + 2; // 오른쪽 자식 노드

		if (left < n && arr.get(left) > arr.get(largest)) {
			largest = left;
		}
		if (right < n && arr.get(right) > arr.get(largest)) {
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

		ArrayList<Integer> heap = new ArrayList<>();
		

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x > 0) {
				heap.add(x);
				buildHeap(heap);
			} else {				
				if (!heap.isEmpty()) {
					bw.write(String.valueOf(heap.get(0)) + "\n" );
					heap.set(0, heap.get(heap.size() - 1)); // 힙이랑 맨 끝 바까주고
					heap.remove(heap.size() - 1); // 맨 끝에 제거
					heapify(heap, heap.size(), 0);
				} else {
					bw.write("0\n");
				}
			}

//			if (x == 0) {
//				if (!heap.isEmpty()) {
//					if (heap.size() >= 2) {
//						
//						int n = heap.size();
//						for (int j = n - 1; j > 0; j--) {
//							// 루트를 배열의 마지막 요소와 교환
//							swap(heap, 0, j);
//							if (heap.get(j) == 0)
//								System.out.println(heap.get(j));
//							// 힙의 크기를 줄이고, 힙 속성을 다시 맞춤
//							heapify(heap, j, 0);
//						}
//						System.out.println(heap.get(heap.lastIndexOf(heap)));
//						heap.remove(heap.lastIndexOf(heap));
//					} else if (heap.size() < 2) {
//						System.out.println(x);
//					}
//				} else if (heap.isEmpty()) {
//					System.out.println("0");
//				}
//			}
		}
		bw.flush();
		bw.close();
	}
}
