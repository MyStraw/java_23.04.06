package BaekJoon.notyet;

import java.util.Scanner;

public class _11720_숫자의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		String num = sc.next();
		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += Character.getNumericValue(num.charAt(i));
		}

		System.out.println(sum);

	}

}
