package BaekJoon.notyet;

import java.util.Scanner;

public class _18330_Petrol {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int total = k + 60;
		int cost = 0;

		if (n <= total) {
			cost = n * 1500;
		} else {
			cost = total * 1500 + (n - total) * 3000;
		}
		System.out.println(cost);
	}

}
