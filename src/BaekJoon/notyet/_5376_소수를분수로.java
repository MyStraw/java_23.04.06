package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5376_소수를분수로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String s = br.readLine();
			long[] result = convert(s);
			System.out.println(result[0] + "/" + result[1]);
		}
	}

	static long[] convert(String s) {
		String[] part = s.split("\\.");
		String integerPart = part[0];
		String decimalPart = part[1];

		long numerator = 0;
		long denominator = 1;

		if (decimalPart.contains("(")) {
			String[] subPart = decimalPart.split("\\(");
			String noRepeat = subPart[0];
			String repeat = subPart[1].substring(0, subPart[1].length() - 1);
			
			long numNoRepeat = Long.parseLong(integerPart + noRepeat);
			long numRepeat = Long.parseLong(integerPart + noRepeat + repeat);

			numerator = numRepeat - numNoRepeat;
			denominator = (long) (Math.pow(10, noRepeat.length() + repeat.length()) - Math.pow(10, noRepeat.length()));
		} else {
			numerator = Long.parseLong(integerPart + decimalPart);
			denominator = (long) Math.pow(10, decimalPart.length());
		}
	
		long gcd = gcd(numerator, denominator);
		return new long[] { numerator / gcd, denominator / gcd };
	}

	static long gcd(long a, long b) {
		while (b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

}
