package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2581_소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int total = 0;
		Queue<Integer> min = new LinkedList<>();
		for (int i = M; i <= N; i++) {
			if (isSosu(i)) {
				total += i;
				min.add(i);
			}
		}
		if (total == 0) {
			System.out.println(-1);
		} else {

			System.out.println(total);
			System.out.println(min.poll());
		}
	}

	public static boolean isSosu(int num) {
		if (num <= 1) {
			return false;
		}

		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
