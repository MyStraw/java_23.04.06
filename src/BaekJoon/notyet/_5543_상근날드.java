package BaekJoon.notyet;

import java.util.Scanner;

public class _5543_상근날드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int burgerMin = 2000;
		int tanMin = 2000;

		for (int i = 0; i < 3; i++) {
			int burger = sc.nextInt();
			if (burger < burgerMin) {
				burgerMin = burger;
			}
		}

		for (int i = 0; i < 2; i++) {
			int tansan = sc.nextInt();
			if (tansan < tanMin) {
				tanMin = tansan;
			}
		}
		System.out.println(burgerMin + tanMin - 50);

	}

}
