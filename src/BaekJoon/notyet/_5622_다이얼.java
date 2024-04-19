package BaekJoon.notyet;

import java.util.Scanner;

public class _5622_다이얼 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String sang = sc.next();

		char[] a = sang.toCharArray();

		int sum = 0;

		for (int i : a) {
			if (i == 'A' | i == 'B' | i == 'C') {
				sum = sum + 3;
			}
			if (i == 'D' | i == 'E' | i == 'F') {
				sum = sum + 4;
			}
			if (i == 'G' | i == 'H' | i == 'I') {
				sum = sum + 5;
			}
			if (i == 'J' | i == 'K' | i == 'L') {
				sum = sum + 6;
			}
			if (i == 'M' | i == 'N' | i == 'O') {
				sum = sum + 7;
			}
			if (i == 'P' | i == 'Q' | i == 'R' | i == 'S') {
				sum = sum + 8;
			}
			if (i == 'T' | i == 'U' | i == 'V') {
				sum = sum + 9;
			}
			if (i == 'W' | i == 'X' | i == 'Y' | i == 'Z') {
				sum = sum + 10;
			}			
		}
		System.out.println(sum);
	}

}
