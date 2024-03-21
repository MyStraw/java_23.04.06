package BaekJoon.notyet;

import java.math.BigInteger;
import java.util.Scanner;

public class _30664_Loteria_Falha {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger zero = new BigInteger("0");
		BigInteger baesu = new BigInteger("42");

		while (true) {
			BigInteger num = sc.nextBigInteger();		
			if (num.equals(zero)) {
				break;
			}			
			if (num.remainder(baesu).equals(zero)) {
				System.out.println("PREMIADO");
			} else {				
				System.out.println("TENTE NOVAMENTE");
			}
		}	
	}
}