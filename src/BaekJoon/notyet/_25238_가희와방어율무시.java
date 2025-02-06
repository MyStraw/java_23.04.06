package BaekJoon.notyet;

import java.util.Scanner;

public class _25238_가희와방어율무시 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double a = sc.nextInt();
		double b = sc.nextInt();

		double damage = a - (a * b / 100);

		if (damage < 100) {
			System.out.println(1);
		} else
			System.out.println(0);
	}

}
