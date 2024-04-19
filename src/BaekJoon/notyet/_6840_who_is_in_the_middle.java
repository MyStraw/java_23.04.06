package BaekJoon.notyet;

import java.util.Scanner;

public class _6840_who_is_in_the_middle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int first = sc.nextInt();
		int second = sc.nextInt();
		int third = sc.nextInt();

		if (first > second) {
			if (second > third) {
				System.out.println(second);
			} else if (first > third) {
				if (third > second) {
					System.out.println(third);
				}
			} else if (third > first) {
				System.out.println(first);
			}
		} else if (first < second) {
			if (second < third) {
				System.out.println(second);
			} else if (first > third) {
				System.out.println(first);

			} else if (third > first) {
				System.out.println(third);
			}

		}
	}
}
