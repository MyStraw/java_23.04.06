package BaekJoon.notyet;

import java.math.BigInteger;
import java.util.Scanner;

public class _14928_큰수_BIG {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger N = sc.nextBigInteger();
		
		BigInteger birth = BigInteger.valueOf(20000303);
		
		BigInteger result = N.mod(birth);
		
		System.out.println(result);
	}

}
