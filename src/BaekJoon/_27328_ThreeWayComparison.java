package BaekJoon;

import java.util.Scanner;

public class _27328_ThreeWayComparison {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		if (A > B) {
			System.out.println(1);
		} else if (A == B) {
			System.out.println(0);
		} else if (A < B) {
			System.out.println(-1);
		}
	}

}
