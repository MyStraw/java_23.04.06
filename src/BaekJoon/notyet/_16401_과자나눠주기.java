package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16401_과자나눠주기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken()); 
		int N = Integer.parseInt(st.nextToken()); 

		int[] snack = new int[N];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < N; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, snack[i]);
		}

		System.out.println(binarySearch(snack, M, 1, max));
	}

	static long binarySearch(int[] snacks, int M, int left, int right) {
		long result = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (canDistribute(snacks, M, mid)) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return result;
	}

	static boolean canDistribute(int[] snacks, int M, int length) {
		int count = 0;
		for (int snack : snacks) {
			count += snack / length;
		}
		return count >= M;
	}

}
