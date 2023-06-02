package Chap8_리스트연습;

import java.util.Scanner;

public class pibo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int F[] = new int[n];

		F[0] = 1;
		F[1] = 1;

		for (int i = 0; i < n-2; i++) {
			F[i + 2] = F[i] + F[i + 1];
		}
		
		System.out.println(F[n-1]);

	}

}
