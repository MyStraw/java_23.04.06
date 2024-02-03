package BaekJoon.notyet;

import java.util.Scanner;

public class _2941_크로아티아_알파벳 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word = sc.nextLine();

		String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

		for (String alpha : croatia) {
			word = word.replace(alpha, "a");
		}

		System.out.println(word.length());
	}
}