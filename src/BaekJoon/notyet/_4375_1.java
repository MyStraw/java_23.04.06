package BaekJoon.notyet;

import java.util.Scanner;

public class _4375_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			long i = 1;
			int count = 1;
			while (i % n != 0) {
				i = i * 10 + 1;
				count++;
			}
			System.out.println(count);
		}
	}
}
