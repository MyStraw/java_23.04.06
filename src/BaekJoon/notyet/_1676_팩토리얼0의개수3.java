package BaekJoon.notyet;

import java.util.Scanner;

public class _1676_팩토리얼0의개수3 { // 미완

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;

		for (int i = 5; i <= N; i *= 5) {
			count += N / i;
		}

		System.out.println(count);
	}

}
