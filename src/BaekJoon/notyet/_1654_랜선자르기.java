package BaekJoon.notyet;

import java.util.Scanner;

public class _1654_랜선자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();

		int lansun[] = new int[K];

		long max = 0;

		for (int i = 0; i < K; i++) {
			lansun[i] = sc.nextInt();
			if (max < lansun[i]) {
				max = lansun[i];
			}
		}

		long min = 1;
		long answer = 0;

		while (min <= max) {
			long mid = (min + max) / 2;
			long count = 0;

			for (int cable : lansun) {
				count += (cable / mid);
			}

			if (count >= N) {
				min = mid + 1;
				answer = Math.max(answer, mid);
			} else {

				max = mid - 1;
			}
		}

		System.out.println(answer);

	}

}
