package BaekJoon.notyet;

import java.util.Scanner;

public class _26209_Intercepting_Information {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		boolean t = true;
		for (int i = 0; i < 8; i++) {
			int bit = sc.nextInt();
			if (bit == 9) {
				t = false;
				break;
			}
		}
	
		if (t) {
			System.out.println("S");
		} else {
			System.out.println("F");
		}

	}

}
