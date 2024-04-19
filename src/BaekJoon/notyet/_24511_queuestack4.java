package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _24511_queuestack4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];

		StringTokenizer stA = new StringTokenizer(br.readLine());
		StringTokenizer stB = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(stA.nextToken());
			B[i] = Integer.parseInt(stB.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		int[] C = new int[M];
		StringTokenizer stC = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			C[i] = Integer.parseInt(stC.nextToken());
		}

		// 위까지 입력

		Deque<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			if (A[i] == 0) {
				queue.addFirst(B[i]);
			}

			else if (queue.isEmpty()) {				
					sb.append(" ");				
			}
		}
		for (int num : C) {
			queue.add(num);
			sb.append(queue.pollFirst()).append(" ");
		}

		System.out.println(sb.toString().trim());
	}
}
