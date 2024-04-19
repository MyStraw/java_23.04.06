package BaekJoon.notyet;

import java.util.Scanner;

public class _1292_쉽게푸는문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		int sum = 0;
		int current = 1;
		int count = 0;

		for (int i = 1; i <= B; i++) {
			if (i >= A) {
				sum += current;
			}

			count++;
			if (count == current) {
				current++;
				count = 0;
			}
		}

		System.out.println(sum);
	}

}
