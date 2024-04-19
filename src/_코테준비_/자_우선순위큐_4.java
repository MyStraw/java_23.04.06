package _코테준비_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 자_우선순위큐_4 {
	public static int minMeetingRooms(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
		PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, Comparator.comparingInt(a -> a));
		allocator.add(intervals[0][1]);
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= allocator.peek()) {
				allocator.poll();
			}
			allocator.add(intervals[i][1]);
		}
		return allocator.size();
	}

	public static void main(String[] args) {
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		System.out.println("최대 회의 수: " + minMeetingRooms(intervals));
	}

}

//입력: intervals = [[0, 30], [5, 10], [15, 20]]
//출력: 최대 회의 수: 2