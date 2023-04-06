package chapter3;

import java.util.Scanner; // crtl + shift + o 하면 메소드? 불러온다. 스캐너

public class Test20_loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("성적을 입력하세요"); // 이걸 윗줄에 쓰면 처음 한번만 언급하고 안한다. 순서 센스
			int score = sc.nextInt();
			char grade;

			if (score > 100 || score < 0) {
				System.out.println("부적절한 점수입니다.");
				break;
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
		System.out.println("프로그램을 종료합니다.");
	}	// crrl + shift + f 하면 들여쓰기 정렬 된다. o는 스캐너 메쏘드. c는 주석
}
