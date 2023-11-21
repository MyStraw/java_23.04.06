package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _7_문제_24173_알고리즘수업_힙정렬1 {

	public static int count = 0;
	public static int K = 0;

	static void swap(int[] a, int idx1, int idx2) {
		count++;
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
		if (K == count) {
			if (a[idx1] > a[idx2]) {
				System.out.println(a[idx2] + " " + a[idx1]);
			} else if (a[idx1] < a[idx2]) {
				System.out.println(a[idx1] + " " + a[idx2]);
			}
		}
	}

	static void buildHeap(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
	}

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
