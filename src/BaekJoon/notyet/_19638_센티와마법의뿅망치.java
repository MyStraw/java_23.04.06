package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _19638_센티와마법의뿅망치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] firstLine = br.readLine().split(" ");
		int n = Integer.parseInt(firstLine[0]);
		int h = Integer.parseInt(firstLine[1]);
		int t = Integer.parseInt(firstLine[2]);

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 최대 힙

		for (int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		int cnt = 0;

		while (t > 0) {
			int tallest = pq.poll();

			if (tallest < h || tallest == 1) {
				pq.add(tallest);
				break;
			}

			pq.add(tallest / 2);
			cnt++;
			t--;
		}

		if (pq.peek() >= h) {
			System.out.println("NO");
			System.out.println(pq.peek());
		} else {
			System.out.println("YES");
			System.out.println(cnt);
		}
	}

}
