package BaekJoon.notyet;

import java.math.BigInteger;
import java.util.Scanner;

public class _13277_큰수곱셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger A = sc.nextBigInteger();
		BigInteger B = sc.nextBigInteger();
		
		BigInteger total = A.multiply(B);
		System.out.println(total);
		
	}

}
