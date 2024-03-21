package _코테준비_;

public class 배열순회_1 {
	public static void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		rotate(nums, k);
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

}
//
//하: 배열 요소의 순환 이동
//문제: 주어진 배열의 모든 요소를 k만큼 오른쪽으로 이동시키라. 배열의 크기를 n이라고 할 때, k는 n보다 클 수도 있음에 유의하라.