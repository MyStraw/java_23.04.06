package Chap6_정렬알고리즘;

import java.util.Random;
import java.util.Scanner;

class QuickSort {

	static int count = 0;

	// --- 배열 요소 a[idx1]과 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 배열을 나눔 ---//
	static void quickSort(int[] a, int left, int right) {

		int pl = left; // 왼쪽 커서
		int pr = right; // 오른쪽 커서
		int x = a[(pl + pr) / 2]; // 피벗(가운데 요소)

		do {
			while (a[pl] < x) {
				pl++;
				count++;
			}
			while (a[pr] > x) {
				pr--;
				count++;
			}
			if (pl <= pr)
				swap(a, pl++, pr--);
			count++;
		} while (pl <= pr);
		if (left < pr)
			quickSort(a, left, pr);
		if (pl < right)
			quickSort(a, pl, right);

		System.out.println("비교횟수 = " + count);
	}

//     System.out.println("피벗의 값은 " + x + "입니다.");
//
//     System.out.println("피벗 이하 그룹 ");
//     for (int i = 0; i <= pl - 1; i++)              // a[0] ～ a[pl - 1]
//         System.out.print(a[i] + " ");
//     System.out.println();
//
//     if (pl > pr + 1) {
//         System.out.println("피벗과 일치하는 그룹 ");
//         for (int i = pr + 1; i <= pl - 1; i++)    // a[pr + 1] ～ a[pl - 1]
//             System.out.print(a[i] + " ");
//         System.out.println();
//     }
//
//     System.out.println("피벗 이상 그룹 ");
//     for (int i = pr + 1; i < n; i++)              // a[pr + 1] ～ a[n - 1]
//         System.out.print(a[i] + " ");
//     System.out.println();
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		System.out.println("단순 삽입 정렬");
		System.out.println("요솟수: ");
		int nx = sc.nextInt();
		int[] x = new int[nx];

		for (int i = 0; i < nx; i++) {
			System.out.print("x[" + i + "]: ");
			x[i] = random.nextInt(100);
		}

		quickSort(x, 0, nx - 1); // 배열 x를 단순교환정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);
	}
}
