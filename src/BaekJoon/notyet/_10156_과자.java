package BaekJoon.notyet;

import java.util.Scanner;

public class _10156_과자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int K = sc.nextInt();
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		if (M - K*N <0) {
			System.out.println(K*N - M);
		}
		else {
			System.out.println(0);
		}
		
		
	}

}
