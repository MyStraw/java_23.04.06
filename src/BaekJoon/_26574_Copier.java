package BaekJoon;

import java.util.Scanner;

public class _26574_Copier {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int copy = sc.nextInt();
			System.out.println(copy + " " + copy);
		}

	}

}
