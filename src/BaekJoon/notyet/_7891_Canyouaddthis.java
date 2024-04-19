package BaekJoon.notyet;

import java.util.Scanner;

public class _7891_Canyouaddthis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			long x = sc.nextInt();
			long y = sc.nextInt();
			long total = x+y;
			System.out.println(total);		
		}
	}
}
