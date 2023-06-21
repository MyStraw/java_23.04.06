package BaekJoon;

import java.util.Scanner;

public class _2475_검증수 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		for (int i = 0 ; i<5; i++) {
			int j = sc.nextInt();
			
			sum = sum + j*j;
		}
		
		System.out.println(sum%10);
	}

}
