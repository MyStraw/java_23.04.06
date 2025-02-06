package BaekJoon.notyet;

import java.util.Scanner;

public class _25915_연세여사랑한다 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String C = sc.next();

		char c = C.charAt(0);

		System.out.println(Math.abs(c - 'I') + 84);

	}
}
