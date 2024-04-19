package BaekJoon.notyet;

import java.util.Scanner;

public class _2231_분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int M = 0;
		boolean F = false;
		for (int i = 0; i < 1_000_000; i++) {
			M = (i / 1000000) 
					+ (i % 1000000) / 100000 
					+ (i % 1000000) % 100000 / 10000 
					+ (i % 1000000) % 100000 % 10000 / 1000	
					+ (i % 1000000) % 100000 % 10000 % 1000 / 100 
					+ (i % 1000000) % 100000 % 10000 % 1000 % 100 / 10 
					+ (i % 1000000) % 100000 % 10000 % 1000 % 100 % 10 / 1; 
			if (i + M == N) {
				System.out.println(i);
				F = true;
				break;
			}			
		}
		if (F == false) {
			System.out.println("0");
		}
	}
}
