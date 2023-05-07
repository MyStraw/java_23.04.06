package _스터디;

import java.util.Scanner;

public class _5월13일스터디_두용액_이진검색 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] N = new int[n];
		int sum = 2_000_000_000;
		int sol1 = 0;
		int sol2 = 0;
		int solution = 0;
		for (int i = 0; i < n; i++) {
			solution = sc.nextInt();
			N[i] = solution;
		}
		sortData(N);

		

		

		System.out.print(sol1 + " ");
		System.out.println(sol2);
	}

	static void sortData(int[] items) {

		for (int i = 0; i < items.length; i++)
			for (int j = 0; j < items.length; j++)
				if (items[i] > items[j])
					swap(items, i, j);
	}

	static void swap(int[] items, int i, int j) { // 정렬 메소드 만들기
		int temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}

//	private static int binSearch(int[] data, int key) {
//		int left = 0;
//		int right = data.length - 1;
//
//		do {
//			int mid = (left + right) / 2;
//
//			if (data[mid] == key) {
//				return mid;
//			} else if (data[mid] < key) {
//				left = mid + 1;
//			} else {
//				right = mid - 1;
//			}
//		} while (left <= right);
//
//		return -1;
//	}

}
