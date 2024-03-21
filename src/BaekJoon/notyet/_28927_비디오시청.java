package BaekJoon.notyet;

import java.util.Scanner;

public class _28927_비디오시청 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t1 = sc.nextInt();
		int e1 = sc.nextInt();
		int f1 = sc.nextInt();

		int t2 = sc.nextInt();
		int e2 = sc.nextInt();
		int f2 = sc.nextInt();

		int totalMax = t1 * 3 + e1 * 20 + f1 * 120;
		int totalMel = t2 * 3 + e2 * 20 + f2 * 120;
		
		if (totalMax > totalMel) {
			System.out.println("Max");
		} else if (totalMax < totalMel) {
			System.out.println("Mel");
		} else {
			System.out.println("Draw");
		}
	}
}