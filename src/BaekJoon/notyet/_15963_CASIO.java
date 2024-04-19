package BaekJoon.notyet;

import java.math.BigInteger;
import java.util.Scanner;

public class _15963_CASIO {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BigInteger N = sc.nextBigInteger();
		BigInteger M = sc.nextBigInteger();

		if (N.equals(M)) {
			System.out.println("1");

		} else
			System.out.println("0");
	}

}
