package chapter5;

import java.util.Scanner; // import 쓰겠다고 선언

public class Test20_1 {

	public static void main(String[] args) { // 메소드. 자바에서는 진입점. 어디선가 시작의 '어디선가; main은 1개만 존재

		Scanner sc = new Scanner(System.in);

		System.out.println("성적을 입력하세요");
		int score = sc.nextInt();
		char grade;

		if (score > 100 || score < 0) {
			System.out.println("부적절한 점수입니다.");
			return;

		}

		if (90 <= score) {
			grade = 'A';
		} else if (score >= 80) {
			grade = 'B';
		} else if (score >= 70) {
			grade = 'C';
		} else if (score >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		System.out.println("당신의 성적은 " + grade + "입니다.");
	}

}
