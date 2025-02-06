package BaekJoon.notyet;

import java.util.Scanner;

public class _10987_모음의개수2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();		

		long count = S.chars().filter(c -> "aeiou".indexOf(c) != -1).count();

		System.out.println(count);
	}
}