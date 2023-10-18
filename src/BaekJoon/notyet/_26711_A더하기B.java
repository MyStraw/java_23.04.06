package BaekJoon.notyet;

import java.math.BigInteger;
import java.util.Scanner;

public class _26711_A더하기B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger A = sc.nextBigInteger();
		BigInteger B = sc.nextBigInteger();
		
		BigInteger C = A.add(B);
		
		System.out.println(C);

	}

}
