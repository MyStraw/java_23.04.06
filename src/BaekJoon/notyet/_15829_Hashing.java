package BaekJoon.notyet;

import java.math.BigInteger;
import java.util.Scanner;

public class _15829_Hashing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int L = sc.nextInt();
		String alpha = sc.next();			
		BigInteger total = BigInteger.ZERO;		
		BigInteger base = BigInteger.valueOf(31);
		BigInteger mod = BigInteger.valueOf(1234567891);
		
		for (int i = 0 ; i<L ; i++) {
			int value = (int) alpha.charAt(i) - 96;			
			BigInteger pow = BigInteger.valueOf(value).multiply(base.pow(i));			
			total = total.add(pow);
		}
		System.out.println(total.mod(mod));
	}
}
