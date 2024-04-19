package BaekJoon.notyet;

import java.util.Scanner;

public class _2745_진법변환3 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String N = sc.next();
		int B = sc.nextInt();
	
		long result = 0;

		for (int i = 0; i < N.length(); i++) {
			int value;
			if (N.charAt(i) >= '0' && N.charAt(i) <= '9') {
				value = N.charAt(i) - '0';

			} else {
				value = N.charAt(i) - 'A' + 10;				
			}			
			result = result * B + value;
		}
		System.out.println(result);
	}
}

//이것도 틀림. 10억이니 long의 문제가 아닐것
//문자를 숫자로 바꿀때 jin을 이용하거나 48을 이용하는것 잘못됨.
//-'0' 을 쓰거나 'A'를 써야함.
//그리고 int f를 두번 하지말고, result도 두번 쓰지말고, 한번에 쓸것
//또한 이렇게 어렵게 result = result + (long) (value * Math.pow(B, N.length() - 1 - i));
//Math.pow 안써도, result * B + value로 쓸수있음.