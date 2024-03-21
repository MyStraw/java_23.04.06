package BaekJoon.notyet;

import java.util.Scanner;

public class _27219_로빈슨크루소 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int v = n / 5;

		int i = n % 5;

		for (int j = 0; j < v; j++) {
			System.out.print("V");
		}		
		
		for (int j = 0; j<i ; j++) {
			System.out.print("I");
		}

	}

}
