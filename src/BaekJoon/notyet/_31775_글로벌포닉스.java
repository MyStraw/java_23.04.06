package BaekJoon.notyet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _31775_글로벌포닉스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s1 = sc.next();
		String s2 = sc.next();
		String s3 = sc.next();

		char c1 = s1.charAt(0);
		char c2 = s2.charAt(0);
		char c3 = s3.charAt(0);

		Set<Character> init = new HashSet<>();
		init.add(c1);
		init.add(c2);
		init.add(c3);

		if (init.contains('l') && init.contains('k') && init.contains('p')) {
			System.out.println("GLOBAL");
		} else {
			System.out.println("PONIX");
		}

	}

}
