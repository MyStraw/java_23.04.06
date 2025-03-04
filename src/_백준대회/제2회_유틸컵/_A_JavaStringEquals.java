package _백준대회.제2회_유틸컵;

import java.util.Scanner;

public class _A_JavaStringEquals {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		String B = sc.nextLine();
		sc.close();

		A = A.equals("null") ? null : A;
		B = B.equals("null") ? null : B;

		try {
			System.out.println(A.equals(B));
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		}

		try {
			System.out.println(A.equalsIgnoreCase(B));
		} catch (NullPointerException e) {
			System.out.println("NullPointerException");
		}
	}

}
