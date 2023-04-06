package chapter3;

import java.util.Scanner;

public class Test24_loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String nation = "KOR";
		Scanner sc = new Scanner(System.in); // 키보드 입력을 system.in 이라 한다.

		while (true) {
			System.out.println("나라를 입력하세요 ex)KOR");

			String nation = sc.next(); // next는 String형 데이터를 return 한다
			// return 이란? (if와 같은색깔 => 예약어). int return = 0 이런식으로 쓸수 없다.
			// 어떤 프로그램이든 위에부터 아래로 내려가는데 리턴을 만나면 불러온 애로 돌아간다.
			// java ~~.class => java가 class를 실행시킨것. java로 돌아간다. return은 메소드를 한방에 다 벗어난다.
			// break는 괄호 하나만 벗어난다.

			switch (nation) { // byte, short, int, char, String 중에서만 가능하다. long, float, double 같은 실수는 안됨.
			case "KOR":
			case "JPN":
			case "CHN":
				System.out.println("아시아 사람이군요");
				break;
			case "GBR":
			case "FRA":
			case "EUA":
				System.out.println("유럽 사람이군요");
				break;
			case "USA":
			case "CAN":
			case "MEX":
				System.out.println("아메리카 사람이군요");
				break;
			default:
				System.out.println("사람이 아니군요");
			}
			System.out.println("외계인과는 대화하지 않습니다");
			// public static int sum(int a, int b) {
			// return a+b: 이런식으로 쓸수도 있다.
		}

	}
}
