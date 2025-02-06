package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class _27922_현대모비스입사프로젝트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);

		int[][] lectures = new int[n][3];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			lectures[i][0] = Integer.parseInt(line[0]);
			lectures[i][1] = Integer.parseInt(line[1]);
			lectures[i][2] = Integer.parseInt(line[2]);
		}

		int maxSum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = i + 1; j < 3; j++) {
				PriorityQueue<Integer> pq = new PriorityQueue<>();
				for (int[] lecture : lectures) {
					int sum = lecture[i] + lecture[j];
					pq.offer(sum);
					if (pq.size() > k)
						pq.poll();
				}

				int currentSum = 0;
				while (!pq.isEmpty()) {
					currentSum += pq.poll();
				}

				maxSum = Math.max(maxSum, currentSum);
			}
		}

		System.out.println(maxSum);
	}

}
