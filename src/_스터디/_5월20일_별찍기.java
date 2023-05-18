package _스터디;

import java.util.Scanner;

public class _5월20일_별찍기 {
	static Scanner sc = new Scanner(System.in);
	static int k = sc.nextInt();
	static double N = Math.pow(3, k);
	
	
	
	static Object stars(Object o) {
		for (int i = 0; i < 3; i++) {
			System.out.print(star());
		}
		System.out.println(" ");
		for (int j = 0; j < 3; j++) {
			if (j != 1)
				System.out.print(star());
			else
				System.out.print(" ");
		}
		System.out.println(" ");
		for (int i = 0; i < 3; i++) {
			System.out.print(star());
		}
		return o;		
		
	}

	static double star() {
		for (int i = 0; i < 3; i++) {
			System.out.print("*");
		}
		System.out.println(" ");
		for (int j = 0; j < 3; j++) {
			if (j != 1)
				System.out.print("*");
			else
				System.out.print(" ");
		}
		System.out.println(" ");
		for (int i = 0; i < 3; i++) {
			System.out.print("*");
		}
		return N;		
		
	}

	public static void main(String[] args) {
		
		stars(N);
		

	}

}
