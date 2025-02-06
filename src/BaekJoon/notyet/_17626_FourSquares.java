package BaekJoon.notyet;

import java.util.Scanner;

public class _17626_FourSquares {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(minSquares(n));		
	}

	public static int minSquares(int n) {		
		if (perfectSquare(n))
			return 1;
		for (int i = 1; i * i <= n; i++) {
			if (perfectSquare(n - i * i))
				return 2;
		}		
		while (n % 4 == 0)
			n /= 4;
		if (n % 8 != 7)
			return 3;		
		return 4;
	}

	public static boolean perfectSquare(int n) {
		int sqrt = (int) Math.sqrt(n);
		return sqrt * sqrt == n;
	}

}
