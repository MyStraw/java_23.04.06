package _코테준비_구현연습;

import java.util.Scanner;

public class 구현2연습 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String time = sc.next();
		System.out.println(convert(time));
	}

	private static String convert(String time) {

		String[] parts = time.split(":");
		//split 만으로도 바로 배열안에 넣을수 있다.
		return parts[0] + "시" + parts[1] + "분";

	}
}
