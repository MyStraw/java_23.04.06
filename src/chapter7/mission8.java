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

	Scanner sc = new Scanner(System.in);
	int money = sc.nextInt(); // 배열루프써보자
	
	
	//배열 써서 나누기 하고 나머지를 안에 집어넣기.
	//이걸 계속 


	
	
	int oman = money / 50000; // int 잖아! 정수

	int omans = money % 50000;

	int ilman = omans / 10000;

	int ilmans = omans % 10000;

	int ochun = ilmans / 5000;

	int ochuns = ilmans % 5000;

	int ilchun = ochun / 1000;

	int ilchuns = ochuns % 1000;


System.out.println("오만원은 "+oman+"장 필요해용");

}
