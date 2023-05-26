package Chap6_정렬알고리즘;

import java.util.Random;

//버블 환정렬(버전 2: 교환 횟수에 따른 멈춤)

import java.util.Scanner;

class SelectionSort {
	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 단순교환정렬(버전 2 : 교환 횟수에 따른 멈춤)---//
	static void SelectionSort(int[] a, int n) {
		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				count++;
				if (a[j] < a[min]) {
					min = j;
				}
				swap(a, i, min);
			}
		}System.out.println("\n 비교 횟수 = " + count);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		System.out.println("버블 정렬(버전 1)");
		System.out.print("요솟수: ");
		int nx = sc.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = random.nextInt(100);
		}

		SelectionSort(x, nx); // 배열 x를 단순교환정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);
	}
}
