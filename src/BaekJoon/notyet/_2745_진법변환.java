package BaekJoon.notyet;

import java.util.Scanner;

public class _2745_진법변환 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String N = sc.next();
		int B = sc.nextInt();

		int jin = 91 - B;

		int result = 0;

		for (int i = 0; i < N.length(); i++) {
			int f = N.charAt(i) - jin;			
			result = result + (int) (f * Math.pow(B, N.length() - 1 - i));
		}
		System.out.println(result);
	}
}

//문자에 대한 처리만 했지, 숫자 처리를 안함.