package BaekJoon.notyet;

import java.util.Scanner;

public class _1193_분수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();

		int line = 1;
		int end = 0;

		while (true) {
			if (X <= end + line) {
				if (line % 2 == 1) {
					System.out.println((line - (X - end - 1)) + "/" + (X - end));
				} else {
					System.out.println((X - end) + "/" + (line - (X - end - 1)));
				}
				break;
			} else {
				end += line;
				line++;
			}
		}
	}
}
