package BaekJoon.notyet;

import java.util.Scanner;

public class _8558_Silnia {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if (n == 0) {
			System.out.println(1); 
		} else {
			int il = 1;
			for (int i = 1; i <= n; i++) {
				il *= i;
				il %= 10;
				if (il == 0)
					break; 
			}
			System.out.println(il);
		}

	}

}
