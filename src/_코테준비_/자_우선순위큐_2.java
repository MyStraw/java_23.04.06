package _코테준비_;

import java.util.PriorityQueue;

public class 자_우선순위큐_2 {
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int num : nums) {
			pq.offer(num);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		System.out.println("K번째 큰 수: " + findKthLargest(nums, k));
	}

}

//입력: nums = [3, 2, 1, 5, 6, 4], k = 2
//출력: K번째 큰 수: 5