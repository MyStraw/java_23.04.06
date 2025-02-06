package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _31860_열심히일하는중 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		int days = 0;
		int y = 0;
		StringBuilder sb = new StringBuilder();

		while (!pq.isEmpty()) {
			int p = pq.poll();
			if (p <= k)
				continue;

			days++;
			y = (y / 2) + p;
			sb.append(y).append("\n");

			p -= m;
			if (p > k)
				pq.add(p);
		}

		System.out.println(days);
		System.out.print(sb);
	}

}
