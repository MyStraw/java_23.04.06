package BaekJoon.notyet;

import java.util.Scanner;

public class _14038_Tournament_Selection {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int win = 0;
	
		for (int i = 0; i < 6; i++) {
			String result = sc.nextLine().trim();
			if (result.equals("W")) {
				win++;
			}
		}
		
		if (win == 5 || win == 6) {
			System.out.println(1);
		} else if (win == 3 || win == 4) {
			System.out.println(2);
		} else if (win == 1 || win == 2) {
			System.out.println(3);
		} else {
			System.out.println(-1);
		}
	
	}

}
