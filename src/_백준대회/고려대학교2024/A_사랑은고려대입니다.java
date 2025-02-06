package _백준대회.고려대학교2024;

import java.util.Scanner;

public class A_사랑은고려대입니다 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		System.out.print("LoveisKoreaUniversity");

		if (N >= 2) {
			for (int i = 1; i < N; i++) {
				System.out.print(" ");
				System.out.print("LoveisKoreaUniversity");
			}
		}

	}

}
