package BaekJoon.notyet;

import java.util.Scanner;

public class _32498_CallForProblems {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		for (int i = 0; i < n; i++) {
			int d = sc.nextInt();
			if (d % 2 == 1) {
				count++;
			}
		}
		System.out.println(count);
	}

}
