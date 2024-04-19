package _코테준비_;

import java.util.PriorityQueue;

public class 자_우선순위큐_3 {
	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int s : scoville) {
			pq.offer(s);
		}
		int count = 0;
		while (pq.size() > 1 && pq.peek() < K) {
			int weakHot = pq.poll();
			int secondWeakHot = pq.poll();
			pq.offer(weakHot + (secondWeakHot * 2));
			count++;
		}
		return pq.peek() >= K ? count : -1;
	}

	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int K = 7;
		System.out.println("섞은 횟수: " + solution(scoville, K));
	}
}

//입력: scoville = [1, 2, 3, 9, 10, 12], K = 7
//출력: 섞은 횟수: 2