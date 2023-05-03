package study;

import java.util.Scanner;

public class _5_1_문자와문자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		int n = sc.nextInt();

		char s = str.charAt(n-1);

		System.out.println(s);
	}

}
