package BaekJoon.notyet;

import java.util.Scanner;

public class _1094_막대기2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();

		int stick = 64;

		int count = 0;

		while (X > 0) {
			if (X - stick == 0) {
				count++;
				break;
			} else if (X - stick / 2 >= 0) {
				X = X - stick / 2;
				count++;
			}
			stick = stick / 2;
		}
		System.out.println(count);
	}
}