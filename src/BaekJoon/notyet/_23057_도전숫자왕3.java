package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class _23057_도전숫자왕3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] nums = new int[N];
		int totalSum = 0;
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			totalSum += nums[i];
		}

		TreeSet<Integer> sums = new TreeSet<>();
		sums.add(0);

		for (int num : nums) {
			TreeSet<Integer> newSums = new TreeSet<>(sums);
			for (int sum : sums) {
				newSums.add(sum + num);
			}
			sums = newSums;
		}

		int count = 0;
		int prev = 0;
		for (int sum : sums) {
			if (sum - prev > 1) {
				count += sum - prev - 1;
			}
			prev = sum;
			if (sum > totalSum)
				break;
		}

		if (totalSum > prev) {
			count += totalSum - prev;
		}

		System.out.println(count);
	}
}