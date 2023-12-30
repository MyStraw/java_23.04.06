package BaekJoon.notyet;

import java.math.BigInteger;
import java.util.Scanner;

public class _22193_Multiply {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		
		
		BigInteger N = sc.nextBigInteger();
		BigInteger M = sc.nextBigInteger();
		BigInteger result = N.multiply(M);
		
		System.out.println(result);
	}

}
