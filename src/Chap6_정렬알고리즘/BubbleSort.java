package Chap6_정렬알고리즘;

import java.util.Random;
import java.util.Scanner;

//버블 정렬(단순 교환 정렬) (버전 1)

class BubbleSort {

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 버블 정렬 ---//
	static void bubbleSort(int[] a, int n) {
		int count = 0;
		for (int i = 0; i < n - 1; i++)
			for (int j = n - 1; j > i; j--) {
				count++;
				if (a[j - 1] > a[j])
					swap(a, j - 1, j);
			}
		System.out.println("\n\n 비교 횟수 = " + count+ "\n"); //비교횟수 = 시간복잡도. 성능을 고려.
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

		bubbleSort(x, nx); // 배열 x를 단순교환정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);
	}
}
