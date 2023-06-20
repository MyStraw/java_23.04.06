package BaekJoon;

import java.util.Scanner;

public class _2675_문자열반복 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int R = sc.nextInt();
			String S = sc.next();	
			
			for (int k = 0; k < S.length(); k++) {			
				for (int j = 0; j < R; j++) {
					System.out.print(S.charAt(k));
				}
			}
		}
	}
}
