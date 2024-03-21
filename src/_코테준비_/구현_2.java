package _코테준비_;

import java.util.Scanner;

public class 구현_2 {

	public static String convert(String time) {
		String[] parts = time.split(":");
		return parts[0] + "시 " + parts[1] + "분";
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String time = scanner.nextLine();
		System.out.println(convert(time));
		scanner.close();
	}

}

//
//1. 시간의 문자열 변환 문제 (중)
//문제 설명: "HH:MM" 형식의 시간을 받아, "HH시 MM분" 형식의 문자열로 변환하세요.
//입력 형식: 하나의 문자열 "HH:MM"이 주어집니다.
//출력 형식: 변환된 문자열 "HH시 MM분"을 출력하세요.
//
//입력 예시
//14:05
//
//출력 예시
//14시 05분
