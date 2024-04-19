package _코테준비_;

import java.util.Deque;
import java.util.LinkedList;

public class 차_덱_3 {

	public static int minOperations(int n, int[] positions) {
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			deque.add(i);
		}

		int totalOps = 0;
		for (int pos : positions) {
			int index = 0;
			for (int num : deque) {
				if (num == pos)
					break;
				index++;
			}

			int ops = Math.min(index, deque.size() - index);
			totalOps += ops;

			while (index-- > 0) {
				deque.addLast(deque.removeFirst());
			}
			deque.removeFirst(); // 원소를 뽑아낸다.
		}

		return totalOps;
	}

	public static void main(String[] args) {
		int n = 10;
		int[] positions = { 2, 9, 5 };
		System.out.println("최소 회전 횟수: " + minOperations(n, positions));
	}

}

//N = 10 (덱의 크기), 원소의 위치: [2, 9, 5]
//출력 예시:
//
//최소 회전 횟수: 8
