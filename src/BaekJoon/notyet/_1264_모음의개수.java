package BaekJoon.notyet;

import java.util.Scanner;

public class _1264_모음의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;

		while (!(str = sc.nextLine()).equals("#")) {
			int moemCount = moem(str);
			System.out.println(moemCount);
		}
	}

	private static int moem(String input) {
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = Character.toLowerCase(input.charAt(i));
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				count++;
			}
		}
		return count;
	}
}