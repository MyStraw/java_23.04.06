package BaekJoon.notyet;

import java.util.Scanner;

public class _10039_평균점수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int total = 0;
		for (int i = 0; i < 5; i++) {
			int student = sc.nextInt();
			if (student < 40) {
				total += 40;
			} else {
				total += student;
			}
		}

		System.out.println(total / 5);
	}

}
