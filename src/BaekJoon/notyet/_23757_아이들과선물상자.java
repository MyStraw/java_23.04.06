package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _23757_아이들과선물상자 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// int gift[] = new int[N];
		int child[] = new int[M];

		// PriorityQueue<Integer> giftPQ = new
		// PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> giftPQ = new PriorityQueue<>((a, b) -> b - a);

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			giftPQ.offer(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		boolean disappointment = false;
		for (int i = 0; i < M; i++) {
			child[i] = Integer.parseInt(st.nextToken());
			if (giftPQ.peek() - child[i] >= 0) {
				giftPQ.offer(giftPQ.poll() - child[i]);
			} else {
				disappointment = true;
			}
		}
		if (!disappointment) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}

	}

}
