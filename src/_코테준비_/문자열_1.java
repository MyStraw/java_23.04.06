package _코테준비_;

import java.util.Scanner;

public class 문자열_1 {
	public static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("뒤집을 문자열을 입력하세요: ");
		String input = scanner.nextLine();
		System.out.println("뒤집힌 문자열: " + reverse(input));
	}

}

//하: 문자열 뒤집기
//
//문제: 주어진 문자열을 뒤집어 반환하라.


//입력 예시
//Copy code
//hello
//출력 예시
//Copy code
//olleh