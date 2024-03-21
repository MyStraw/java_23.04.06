package _코테준비_;

import java.util.PriorityQueue;

public class 배열순회_3 {
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int val : nums) {
			pq.add(val);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		System.out.println(findKthLargest(nums, k));
	}

}

//상: 정수 배열의 K번째 큰 요소
//
//문제: 정렬되지 않은 배열에서 K번째로 큰 요소를 찾아라.