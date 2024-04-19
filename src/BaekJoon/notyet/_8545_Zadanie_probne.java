package BaekJoon.notyet;

import java.util.Scanner;

public class _8545_Zadanie_probne {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] W = sc.next().toCharArray();

		for (int i = W.length - 1; i >= 0; i--) {
			System.out.print(W[i]);
		}
	}

}
