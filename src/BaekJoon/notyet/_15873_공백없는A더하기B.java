package BaekJoon.notyet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15873_공백없는A더하기B {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int A, B;

		if (input.length() == 2) {
			A = Character.getNumericValue(input.charAt(0));
			B = Character.getNumericValue(input.charAt(1));
		} else if (input.length() == 3) {
			if (input.startsWith("10")) {
				A = 10;
				B = Character.getNumericValue(input.charAt(2));
			} else {
				A = Character.getNumericValue(input.charAt(0));
				B = 10;
			}
		} else {
			A = 10;
			B = 10;
		}

		System.out.println(A + B);
	}
}
