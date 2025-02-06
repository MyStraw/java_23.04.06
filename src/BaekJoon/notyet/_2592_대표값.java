package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _2592_대표값 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = new int[10];
		int sum = 0;
		HashMap<Integer, Integer> freq = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i];
			freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
		}

		int avg = sum / 10;
		int mode = nums[0];
		int maxCount = 0;

		for (int key : freq.keySet()) {
			if (freq.get(key) > maxCount) {
				maxCount = freq.get(key);
				mode = key;
			}
		}

		System.out.println(avg);
		System.out.println(mode);
	}

}
