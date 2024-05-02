package BaekJoon.notyet;

import java.util.Scanner;

public class _24416_피보나치수1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int recurCount = fiboRecur(n);
		int dpCount = fiboDP(n);

		System.out.println(recurCount + " " + dpCount);
		
	}

	static int recurCount = 0;
	public static int fiboRecur(int n){
		
		if (n ==1 || n ==2){
			recurCount++;
			return 1;
		}

		else{
			recurCount++;
			return fiboRecur(n - 1) + fiboRecur(n - 2);
		}			
	}

	public static int fiboDP(int n){
		int[] f = new int[n + 1];
		f[1] = f[2] = 1;
		int dpCount = 0;

		for (int i = 3; i <= n; i++) {
			dpCount++; // 코드2 실행
			f[i] = f[i - 1] + f[i - 2];
		}
		return dpCount;

	}


}
