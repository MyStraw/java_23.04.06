package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _12847_꿀아르바이트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Deque<Long> deque = new LinkedList<>();

		long max = 0;
		long total = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			deque.offerLast(Long.parseLong(st.nextToken()));
			total += deque.peekLast();

			if (deque.size() > m) {
				total -= deque.pollFirst();
			}

			if (deque.size() == m) {
				if (max < total) {
					max = total;

				}
			}
		}
		System.out.println(max);
	}
}
