package BaekJoon.notyet;

import java.util.Scanner;

public class _1929_소수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		int sosu[] = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			sosu[i] = i;
		}

		for (int i = 2; i * i <= n; i++) {

			if (sosu[i] == 0) {
				continue;
			}
			for (int j = i * i; j <= n; j += i) {
				sosu[j] = 0;
			}
		}

		for (int i = m; i <= n; i++) {

			if (sosu[i] != 0) {
				System.out.print(sosu[i] + " ");
			}
		}

	}

}
