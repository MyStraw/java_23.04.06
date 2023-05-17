package Chap5_재귀알고리즘;

import java.util.Scanner;

class Recur {

	static void recur(int n) {
		while(n>0) { //추가		
		//if (n > 0) {
			
			System.out.println("recur(" + n + "-1);");
			recur(n - 1);
			System.out.println(n);
			System.out.println("recur(" + n + "-2);");
			//recur(n - 2);			
			n = n-2; //추가
		} //추가한부분이랑 주석단부분 서로 바꿀수있다.
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("정수를 입력하세요.: ");
		int x = stdIn.nextInt();

		recur(x);
	}

}