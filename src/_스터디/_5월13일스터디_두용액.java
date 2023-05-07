package _스터디;

import java.util.Scanner;

public class _5월13일스터디_두용액 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] N = new int[n];
		int sum = 2_000_000_000;
		int sol1 = 0;
		int sol2 = 0;

		for (int i = 0; i < n; i++) {
			int solution = sc.nextInt();
			N[i] = solution;
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (sum > Math.abs(N[i] + N[j])) {
					sum = Math.abs(N[i] + N[j]);
				}
				if (sum == Math.abs(N[i] + N[j])) {
					sol1 = N[i];
					sol2 = N[j];

				}
			}
		}
		System.out.print(sol1 + " ");
		System.out.println(sol2);
	}
}
