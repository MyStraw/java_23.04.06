package _코테준비_;

public class 배열순회_2 {
	public static int maxSubArray(int[] nums) {
		int maxSoFar = nums[0], maxEndingHere = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));
	}

}
//
//
//중: 배열에서 요소의 최대 연속 합
//
//문제: 주어진 배열에서 가장 큰 연속합을 가진 부분 배열의 합을 찾아라.