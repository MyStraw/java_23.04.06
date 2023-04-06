package chapter3;

import java.util.Scanner;

public class mission1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("국어 점수를 입력하세요.");
			int kor = sc.nextInt();
			System.out.println("영어 점수를 입력하세요.");
			int eng = sc.nextInt();// next 기본은 String			
			System.out.println("수학 점수를 입력하세요");
			int math = sc.nextInt();
			
			String result; // 여기서는 초기화만 해주고 아래에서 값

			float sum = kor + eng + math;
			float mid = sum / 3;

			if (60 > kor || 60 > eng || 60 > math) {
				result = "과락"; // 아래에서 값
			} else if (mid >= 70) {
				result = "통과";
			} else {
				result = "과락";
			}
			System.out.println("입력 : " + kor + ',' + eng + ',' + math + ", " + "총계 : " + sum + ", " + "평균 : "
					+ String.format("%.2f", mid) + " -> " + result);
		}//String.format("%.2f", mid) 소수점 2자리 까지 표현법

	}
}

