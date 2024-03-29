package _스터디_자료구조;

import java.util.Scanner;

public class _6_1_힙정렬 {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	static void downHeap(int[] a, int left, int right) {
		int temp = a[left];
		int child;
		int parent;

		for (parent = left; parent < (right + 1) / 2; parent = child) {
			int cl = parent * 2 + 1;
			int cr = parent * 2 + 2;
			
			if (cr <= right && a[cr] > a[cl]) {
				child = cr;
			} else {
				child = cl;
			}
			
			if (temp >= a[child]) {
				break;
			}
			a[parent] = a[child];
		}
		a[parent] = temp;
	}

	static void heapSort(int[] a, int n) { //힙으로 만들기
		for (int i = (n - 1) / 2; i >= 0; i--) { // (i-1)/2는 부모. n/2-1로 해도 된다.
			downHeap(a, i, n - 1);
		}
		for (int i = n - 1; i > 0; i--) {
			swap(a, 0, i);
			downHeap(a, 0, i - 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("힙 정렬");
		System.out.println("데이터수: ");
		int nx = sc.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "]: ");
			x[i] = sc.nextInt();
		}

		heapSort(x, nx);

		System.out.println("오름차순으로 정렬했습니다");
		for (int i = 0; i < nx; i++) {
			System.out.println("x[" + i + "]=" + x[i]);
		}
	}

}
