package BaekJoon.notyet;

import java.util.Scanner;

public class _25784_Easy_to_solve_expressions {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if (a == b + c || b == a + c || c == a + b) {
			System.out.println(1);
		} else if (a == b * c || b == a * c || c == a * b) {
			System.out.println(2);
		} else {
			System.out.println(3);
		}
	}

}
