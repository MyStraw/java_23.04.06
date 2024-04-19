package BaekJoon.notyet;

import java.util.Scanner;

public class _2908_상수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		String A = Integer.toString(a);
		String B = Integer.toString(b);

		for (int i = A.length() - 1; i >= 0; i--) {
			if (A.charAt(i) > B.charAt(i)) {
				reverse(A);
				break;
			}else if (A.charAt(i) < B.charAt(i)) {
				reverse(B);
				break;
			}		
		}
	}

	private static void reverse(String S) {
		for (int j = S.length() - 1; j >= 0; j--) {
			System.out.print(S.charAt(j)); 
		}
	}
}
