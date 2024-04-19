package _코테준비_;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 차_덱_2 {
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];
		int[] result = new int[nums.length - k + 1];
		Deque<Integer> deque = new LinkedList<>();

		for (int i = 0; i < nums.length; i++) {
			// 윈도우 범위를 벗어난 요소를 제거한다.
			while (!deque.isEmpty() && deque.peek() < i - k + 1) {
				deque.poll();
			}

			// 현재 요소보다 작은 값을 가진 인덱스를 deque에서 제거한다.
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}

			deque.offer(i);

			// 결과 배열에 최대값을 저장한다.
			if (i >= k - 1) {
				result[i - k + 1] = nums[deque.peek()];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		System.out.println("최대 슬라이딩 윈도우: " + Arrays.toString(maxSlidingWindow(nums, k)));
	}

}


//입력 예시:
//nums = [1,3,-1,-3,5,3,6,7], k = 3
//
//출력 예시:
//[3,3,5,5,6,7]
