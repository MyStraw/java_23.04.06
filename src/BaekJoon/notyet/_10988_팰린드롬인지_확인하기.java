package BaekJoon.notyet;

import java.util.Scanner;

public class _10988_팰린드롬인지_확인하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String pal = sc.next();

		char[] palindrome = pal.toCharArray();

		int start = 0;
		int end = pal.length() - 1;

		while (start <= end) {
			if ((start == end || end - start == 1) && palindrome[start] == palindrome[end]) {
				System.out.println("1");
				break;
			}

			else if (palindrome[start] == palindrome[end]) {
				start++;
				end--;
			}

			else {
				System.out.println("0");
				break;
			}
		}
	}
}
