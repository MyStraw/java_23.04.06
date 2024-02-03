package BaekJoon.notyet;

import java.util.Scanner;

public class _26307_correct {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int hour = sc.nextInt();
		int minute = sc.nextInt();
		int start = 9;
		int total = (hour-start) * 60 + minute;

		System.out.println(total);
	}

}
