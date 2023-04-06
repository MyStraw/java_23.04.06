package chapter3;

import java.util.Scanner;

public class Test22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 12;
		int b = 2;
		char op = '+';
//		Scanner sc = new Scanner(System.in);
		
	//	System.out.println("Op[=,-,*,/]:");
		
		
		switch(op) {
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
		}

	}

} //break = 괄호를 벗어나라. break 없이 실행하면 4개 전부 다 실행된다.
