package _스터디;

import java.util.Arrays;
import java.util.Scanner;

public class _5월13일스터디_두용액_이진검색 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] N = new int[n];
		
		int sol1 = 0;
		int sol2 = 0;
		int solution = 0;
		for (int i = 0; i < n; i++) {
			solution = sc.nextInt();
			N[i] = solution;
		}

		Arrays.sort(N); // 이거쓰면 sortData 2중포문도, swap도 쓸필요가 없어진다.

		System.out.print(sol1 + " ");
		System.out.println(sol2);
	}

	private static int binSearch(int[] N, int key) {
		int left = 0;
		int right = N.length - 1;
		int sum = 2_000_000_000;

		do {
			int mid = (left + right) / 2;

			if (sum > Math.abs(N[left] + N[right])) {
				sum = N[left] + N[right];
			} else if (N[mid] < key) {
				left ++;
			} else {
				right = mid - 1;
			}
		} while (left <= right);

		return -1;
	}

}
