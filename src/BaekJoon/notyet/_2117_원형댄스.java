package BaekJoon.notyet;

import java.util.Scanner;

public class _2117_원형댄스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		

		if (n == 1 || n == 2) {
			System.out.println(0);
		} else if (n == 3) {
			System.out.println(1);
		} else {
			int start = 2;
			int d = 2;
			int count = 0;
			for (int i = 0; i < n - 4; i++) {
				start += d;
				count++;
				if (count == 2) {
					count = 0;
					d++;
				}
			}
			System.out.println(start);
		}
	}

}
