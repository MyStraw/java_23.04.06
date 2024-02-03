package BaekJoon.notyet;

import java.math.BigInteger;
import java.util.Scanner;

public class _8437_Julka { //미완
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger total = sc.nextBigInteger();
		
		BigInteger gap = sc.nextBigInteger();
		
		
		BigInteger Kaudia = total.add(gap).divide(BigInteger.valueOf(2));
		BigInteger Natalia = total.subtract(Kaudia);
		
		System.out.println(Kaudia.toString());
		System.out.println(Natalia.toString());
				
	}
}
