package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _2346_풍선터뜨리기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		Deque<XandY> deque = new LinkedList<>();
		int x;
		int y;
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());
			y = i;
			deque.addLast(new XandY(x, y));
		}

		for (int i = 0; i < n; i++) {
			result[i] = deque.peekFirst().getY() + 1;
			int first = deque.pollFirst().getX();

			if (first > 0) {
				for (int j = 0; j < first - 1; j++) {
					deque.addLast(deque.pollFirst());
				}
			} else if (first < 0) {
				for (int j = first ; j < 0; j++) {
					deque.addFirst(deque.pollLast());
				}
			}
		}
		for (int z : result) {
			System.out.print(z+" ");
		}

	}

	static class XandY {
		int x;
		int y;

		public XandY(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}
	}

}
