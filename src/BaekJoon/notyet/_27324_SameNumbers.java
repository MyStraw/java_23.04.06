package BaekJoon.notyet;

import java.util.Scanner;

public class _27324_SameNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int tens = N/10;
		int ones = N%10;
		
		if (tens == ones) {
			System.out.println(1);
		}else
			System.out.println(0);
	}

}
