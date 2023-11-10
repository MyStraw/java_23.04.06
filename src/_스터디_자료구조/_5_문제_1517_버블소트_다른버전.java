package _스터디_자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5_문제_1517_버블소트_다른버전 {
	static int[] temp;
	static long inversionCount;

	static void mergeSort(int[] array, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}

	static void merge(int[] array, int left, int mid, int right) {
		for (int i = left; i <= right; i++) {
			temp[i] = array[i];
		}

		int i = left;
		int j = mid + 1;
		int k = left;

		while (i <= mid && j <= right) {
			if (temp[i] <= temp[j]) {
				array[k++] = temp[i++];
			} else {
				array[k++] = temp[j++];
				inversionCount += (mid - i + 1);
			}
		}

		while (i <= mid) {
			array[k++] = temp[i++];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		temp = new int[n];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(input[i]);
		}
		mergeSort(array, 0, n - 1);		
		System.out.println(inversionCount);
	}
}
