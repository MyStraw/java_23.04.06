package _bitcoding;

import java.util.Scanner;

public class _124 {
	public static void main(String[] args) {

		while (true) {

			System.out.println("성적을 입력하세요 : a,b,c,d,f");

			Scanner sc = new Scanner(System.in);

			String grade = sc.next();

			switch (grade) {

			case "a":
			case "b":
				System.out.println("참 잘했습니다");
				break;

			case "c":

			case "d":
				System.out.println("좀 더 노력하세요");
				break;

			case "f":
				System.out.println("다음 학기에 다시 수강하세요");
				break;
			}

		}
	}

}
