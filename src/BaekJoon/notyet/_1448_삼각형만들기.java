package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1448_삼각형만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		int maxSum = -1;

		for (int i = n - 1; i >= 2; i--) {
			if (arr[i] < arr[i - 1] + arr[i - 2]) {
				maxSum = arr[i] + arr[i - 1] + arr[i - 2];
				break;
			}
		}

		System.out.println(maxSum);
	}

}
