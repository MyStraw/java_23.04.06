package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2428_표절 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] size = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(size);

		long count = 0;
		
		for (int i = 0; i < n; i++) {
			int min = (int) Math.ceil(size[i] * 0.9);
			int left = binarySearchLeft(size, i, min);
			count += (i - left);
		}

		System.out.println(count);
	}
	
	private static int binarySearchLeft(int[] size, int end, int target) {
		int start = 0;
		while (start < end) {
			int mid = (start + end) / 2;
			if (size[mid] >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

}
