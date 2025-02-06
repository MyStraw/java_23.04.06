package BaekJoon.notyet;

import java.util.Scanner;

public class _32775_가희와4시간의벽1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int S_ab = sc.nextInt();

		int F_ab = sc.nextInt();

		 if (S_ab > 240 || S_ab > F_ab) {
	            System.out.println("flight");
	        } else {
	            System.out.println("high speed rail");
	        }

	}

}
