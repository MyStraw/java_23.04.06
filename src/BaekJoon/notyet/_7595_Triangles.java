package BaekJoon.notyet;

import java.util.Scanner;

public class _7595_Triangles {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n;

		while ((n = sc.nextInt()) != 0) {

			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}

		}
	}

}
