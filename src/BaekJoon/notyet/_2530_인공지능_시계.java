package BaekJoon.notyet;

import java.util.Scanner;

public class _2530_인공지능_시계 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();

		int totalSeconds = C + D + (B * 60) + (A * 3600);

		int endHour = (totalSeconds / 3600) % 24;
		int endMinute = (totalSeconds % 3600) / 60;
		int endSecond = totalSeconds % 60;

		System.out.println(endHour + " " + endMinute + " " + endSecond);

	}
}