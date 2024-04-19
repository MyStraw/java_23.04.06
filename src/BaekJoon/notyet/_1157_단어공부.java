package BaekJoon.notyet;

import java.util.Scanner;

public class _1157_단어공부 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String alpha = "abcdefghijklmnopqrstuvwxyz";

		char[] str = s.toLowerCase().toCharArray();
		char[] alphabet = alpha.toCharArray();

		int[] countt = new int[str.length];

		int count = 0;
		
		for (int i = 0; i < str.length-1; i++) {		
			for (int j = 1; j < str.length; j++) {
				if (str[i] == str[j]) {
					countt[i] += 1;
				}
			}
		}
		
		

		int countmax = 0;
		int countjung = 0;
		for (int i = 0; i < countt.length; i++) {
			if (countmax < countt[i]) {
				countmax = countt[i];
			}
		}

		for (int i = 0; i < countt.length; i++) {
			if (countmax == countt[i]) {
				countjung++;
			}
		}

		if (countjung >= 2) {
			System.out.println("?");
		} else {
			System.out.println(countmax);

		}
	}
}
