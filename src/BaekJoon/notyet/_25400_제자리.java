package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _25400_제자리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}

		int curNum = 1;
		int count = 0;
		while (!queue.isEmpty()) {
			int x = queue.poll();
			if (x == curNum) {
				curNum++;
			} else {
				count++;
			}
		}		
		System.out.println(count);
	}

}
