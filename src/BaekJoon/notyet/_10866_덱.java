package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _10866_덱 { //제출해
	static int N;

	static class IntDeque {
		private int[] deque;
		private int capacity;
		private int front; 
		private int back; 
		private int num; 

		public IntDeque(int i) {
			num = front = back = 0;
			capacity = i;
			try {
				deque = new int[capacity];
			} catch (OutOfMemoryError e) { 
				capacity = 0;
			}
		}

		public int pushFront(int x) {
			if (back == capacity)
				back = 0;
			back++;
			num++;
			for (int i = N - 2; i >= 0; i--) {
				deque[i + 1] = deque[i];
			}
			deque[front] = x;			
			return x;
		}

		public int pushBack(int x) {
			deque[back++] = x;
			num++;
			if (back == capacity)
				back = 0;
			return x;
		}

		public int popFront() {		
			if (num == 0)
				return -1;	
			int x = deque[front++];
			num--;
				
			return x;
		}

		public int popBack() {
			if (num == 0)
				return -1;		
			num--;
			return deque[--back];
			
		}		
		

		public int size() {
			return num;
		}

		public int empty() {
			if (num == 0)
				return 1;
			return 0;
		}

		public int front() {
			if (num == 0) {
				return -1;
			}
			return deque[front];
		}

		public int back() {
			if (num == 0) {
				return -1;
			}
			return deque[back - 1];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		IntDeque intDeque = new IntDeque(N);

		for (int i = 0; i < N; i++) {
			String order = br.readLine();
			if (order.startsWith("push_front")) {
				String[] command = order.split(" ");
				int num = Integer.parseInt(command[1]);
				intDeque.pushFront(num);
			} else if (order.startsWith("push_back")) {
				String[] command = order.split(" ");
				int num = Integer.parseInt(command[1]);
				intDeque.pushBack(num);
			} else if (order.equals("pop_front")) {
				System.out.println(intDeque.popFront());
			} else if (order.equals("pop_back")) {
				System.out.println(intDeque.popBack());
			} else if (order.equals("size")) {
				System.out.println(intDeque.size());
			} else if (order.equals("empty")) {
				System.out.println(intDeque.empty());
			} else if (order.equals("front")) {
				System.out.println(intDeque.front());
			} else if (order.equals("back")) {
				System.out.println(intDeque.back());
			}
		}
	}

}
