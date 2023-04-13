package chapter7;
//최소 지폐 수 계산

//상품가격 152,365원을 지불하기 위해 필요한 최소 지폐 장수는 아래와 같다.

//5만원 * 3장
//1만원 * 0장
//5천원 * 0장
//1천원 * 2장
//천원 미만은 할인하고 임의의 금액을 지불하기 위해 필요한 지폐 장수를 구하는 프로그램을 작성하세요.

import java.util.Scanner;

public class mission8 {

	public static void main(String[] args) {

		while (true) {
			System.out.println("얼마?");
			Scanner sc = new Scanner(System.in);
			int money = sc.nextInt(); // 배열루프써보자

			// 배열 써서 나누기 하고 나머지를 안에 집어넣기.
			// 이걸 계속

			int oman = money / 50000; // int를 써서 나머지를 버려버린다.
			int omans = money % 50000; // 나머지를 받아온다
			int ilman = omans / 10000;
			int ilmans = omans % 10000;
			int ochun = ilmans / 5000;
			int ochuns = ilmans % 5000;
			int ilchun = ochuns / 1000;
			int ilchuns = ochuns % 1000;

			System.out.println(money / 50000);
			System.out.println(money % 50000 / 10000);
			System.out.println(money % 50000 % 10000 / 5000);
			System.out.println(money % 50000 % 10000 % 5000 / 1000);
//
//		int omans = money % 50000;
//		int ilman = omans / 10000;
//		int ilmans = omans % 10000;
//		int ochun = ilmans / 5000;
//		int ochuns = ilmans % 5000;
//		int ilchun = ochuns / 1000;
//		int ilchuns = ochuns % 1000;
//		
//
//		System.out.println("오만원은 " + oman + "장 필요해용");
//		System.out.println("일만원은 " + ilman + "장 필요해용");
//		System.out.println("오천원은 " + ochun + "장 필요해용");
//		System.out.println("일천원은 " + ilchun + "장 필요해용");

			System.out.println("오만원은 " + oman + "장 필요해용");
			System.out.println("일만원은 " + ilman + "장 필요해용");
			System.out.println("오천원은 " + ochun + "장 필요해용");
			System.out.println("일천원은 " + ilchun + "장 필요해용");

			System.out.println("-------------------------------------------");

			System.out.println(money / 50000);
			System.out.println(money % 50000 / 10000);
			System.out.println(money % 50000 % 10000 / 5000);
			System.out.println(money % 50000 % 10000 % 5000 / 1000);

			System.out.println("-------------------------------------------");

//		int[] cash = new int[4];
//		cash[0]= 50000;
//		cash[1]= 10000;
//		cash[2]= 5000;
//		cash[3]= 1000;

			int[] cash = { 50000, 10000, 5000, 1000 };
			for (int i : cash) { // i에 배열을 순차적으로 입력
				int quo = money / i;
				System.out.println(i + "원짜리 " + quo + "장 필요해");
				money = money % i;

			}

		}

	}
}