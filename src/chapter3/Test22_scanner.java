package chapter3;

import java.util.Scanner;

public class Test22_scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Op[=,-,*,/]:");
			char op = sc.next().charAt(0);
			int a = 0;
			int b = 0;

			if (op == '+' || op == '-' || op == '*' || op == '.') {
				System.out.println("첫번째 숫자를 입력하세요");
				a = sc.nextInt(); // int a~ 이렇게 하다가 위로 int a를 빼버렸다. 왜? 중괄호를 나가게 되면 a 선언이 사라진다. 스위치에; 적용이 안됨.

				System.out.println("두번째 숫자를 입력하세요");
				b = sc.nextInt();
//		Scanner sc = new Scanner(System.in);
			}

			switch (op) {
			case '+':
				System.out.println("+:" + (a + b));
				break;
			case '-':
				System.out.println("-:" + (a - b));
				break;
			case '*':
				System.out.println("*:" + (a * b));
				break;
			case '/':
				System.out.println("/:" + (a / b));
				break;
			default:
				sc.close();
				return;
			}

		}

	}
}// break = 괄호를 벗어나라. break 없이 실행하면 4개 전부 다 실행된다.
