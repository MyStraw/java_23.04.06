package BaekJoon.notyet;

import java.util.Scanner;

public class _아레나A번_세제곱의합 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int N1 = 0;
		
		int N3 = 0;
		
		for(int i = 1 ; i <=N; i++) {
			N1 += i;		
			N3 += i*i*i;
		}
		int N2 = N1*N1;
		
	
				
		System.out.println(N1);
		System.out.println(N2);
		System.out.println(N3);
		
	}

}
