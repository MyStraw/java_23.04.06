package BaekJoon.notyet;

import java.util.Scanner;

public class _15025_JudgingMoose {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();		

		if (l == 0 && r == 0) {
			System.out.println("Not a moose");
		} else if (l == r) {
			System.out.println("Even " + (l + r));
		} else {
			int max = Math.max(l, r);
			System.out.println("Odd " + (2 * max));
		}
	}

}
