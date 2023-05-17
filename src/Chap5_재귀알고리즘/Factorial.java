package Chap5_재귀알고리즘;

import java.util.Scanner;

class Factorial {

	private int x;

	public Factorial(int x) {
		this.x = x;
	}

	public int factorial2() {
		return factorial(this.x);

	}

	static int factorial(int n) {
		return (n>0) ? n*factorial(n-1) : 1; //삼항연산자로 한줄로 간단하게.
		
		
//		if (n > 0) {
//			//System.out.println("return " + n + "* factorial" + n + "-1");
//			return n * factorial(n - 1);
//		} else
//			return 1;
	}

	public static void main(String[] args) {

		Scanner stdIn = new Scanner(System.in);

		System.out.println("정수를 입력하세요: ");
		int x = stdIn.nextInt();

		Factorial fact = new Factorial(x);

		System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
		System.out.println(x + "의 팩토리얼은 " + fact.factorial2() + "입니다.");

	}

}
