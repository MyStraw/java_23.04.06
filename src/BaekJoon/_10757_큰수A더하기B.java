package BaekJoon;

import java.math.BigInteger;
import java.util.Scanner;

public class _10757_큰수A더하기B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger A = sc.nextBigInteger();
		BigInteger B = sc.nextBigInteger();
		
		BigInteger total = A.add(B);
		System.out.println(total);
		
	}

}
