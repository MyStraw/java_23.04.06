package BaekJoon.notyet;

import java.util.Scanner;

public class _2745_진법변환2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String N = sc.next();
		int B = sc.nextInt();

		int jin = 91 - B;

		long result = 0;

		for (int i = 0; i < N.length(); i++) {
			if (N.charAt(i) >= '0' && N.charAt(i) <= '9') {
				int f = N.charAt(i) - 48;
				result = result + (long) (f * Math.pow(B, N.length() - 1 - i));
			} else {
				int f = N.charAt(i) - jin;
				result = result + (long) (f * Math.pow(B, N.length() - 1 - i));
			}

		}
		System.out.println(result);
	}
}

//이것도 틀림. 10억이니 long의 문제가 아닐것
//문자를 숫자로 바꿀때 jin을 이용하거나 48을 이용하는것 잘못됨.
//-'0' 을 쓰거나 'A'를 써야함.
//그리고 int f를 두번 하지말고, result도 두번 쓰지말고, 한번에 쓸것