package _스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _5월13일스터디_두용액_이진검색 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] N = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());

		int sol1 = 0;
		int sol2 = 0;

		for (int i = 0; i < n; i++) {
			N[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(N); // 이거쓰면 sortData 2중포문도, swap도 쓸필요가 없어진다.

		int left = 0;
		int right = N.length - 1;
		int sum = 2_000_000_000;

		while (left < right) {
			if (sum > Math.abs(N[left] + N[right])) {
				sum = Math.abs(N[left] + N[right]);
				sol1 = N[left];
				sol2 = N[right];
			}
			if (0 > N[left] + N[right]) {
				left++;
			} else {
				right--;
			}
		}
		System.out.print(sol1 + " " + sol2);		
	}

}
