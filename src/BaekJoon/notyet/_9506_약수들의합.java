package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _9506_약수들의합 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == -1) {
				break;
			}
			int total = 0;
			Queue<Integer> yak = new LinkedList<>();
			for (int i = 1; i < n; i++) {
				if (n % i == 0) {
					total += i;
					yak.add(i);
				}
			}
			if (total == n) {
				System.out.print(n + " = ");
				int size = yak.size();
				for (int i = 0; i < size - 1; i++) {
					System.out.print(yak.poll() + " + ");
				}
				System.out.println(yak.poll());
			}
			else {
				System.out.println(n +" is NOT perfect.");
			}
		}
	}
}
