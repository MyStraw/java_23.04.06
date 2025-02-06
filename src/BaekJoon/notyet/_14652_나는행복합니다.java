package BaekJoon.notyet;

import java.util.Scanner;

public class _14652_나는행복합니다 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();

		int garo = K % M;
		int sero = K / M;

		System.out.println(sero + " " + garo);
	}

}
