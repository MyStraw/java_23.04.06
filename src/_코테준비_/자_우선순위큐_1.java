package _코테준비_;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class 자_우선순위큐_1 {
	private PriorityQueue<Integer> maxHeap; // lower half
	private PriorityQueue<Integer> minHeap; // higher half
	
	

	public 자_우선순위큐_1() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

	public void addNum(int num) {
		maxHeap.offer(num);
		minHeap.offer(maxHeap.poll());
		if (minHeap.size() > maxHeap.size()) {
			maxHeap.offer(minHeap.poll());
		}
	}

	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		} else {
			return maxHeap.peek();
		}
	}

	public static void main(String[] args) {
		Queue<Integer> que = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		자_우선순위큐_1 finder = new 자_우선순위큐_1();
		finder.addNum(1);
		finder.addNum(2);
		System.out.println("중앙값: " + finder.findMedian()); // 중앙값: 1.5
		finder.addNum(3);
		System.out.println("중앙값: " + finder.findMedian()); // 중앙값: 2.0
	}

}
 