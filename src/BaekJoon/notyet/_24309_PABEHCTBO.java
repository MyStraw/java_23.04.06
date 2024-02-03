package BaekJoon.notyet;

import java.math.BigInteger;
import java.util.Scanner;

public class _24309_PABEHCTBO {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigInteger a = new BigInteger(sc.next());
		BigInteger b = new BigInteger(sc.next());
		BigInteger c = new BigInteger(sc.next());

		BigInteger x = b.subtract(c).divide(a);

		System.out.println(x);
	}

}
