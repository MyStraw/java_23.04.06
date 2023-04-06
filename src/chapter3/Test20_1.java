package chapter3;

import java.util.Scanner; // crtl + shift + o 하면 메소드? 불러온다. 스캐너

public class Test20_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);  //키보드 입력을 system.in 이라 한다.
		
		System.out.println("성적을 입력하세요");
		int score = sc.nextInt();		
		char grade;
		
		if(score > 100 || score < 0) { // 나중에 default가 이거겠지? 0~100 이외의 점수
			System.out.println("부적절한 점수입니다.");
			return;// 끝내고 되돌아간다.
			//return 이란? (if와 같은색깔 => 예약어). int return = 0 이런식으로 쓸수 없다.
			//어떤 프로그램이든 위에부터 아래로 내려가는데 리턴을 만나면 불러온 애로 돌아간다.
			//java ~~.class => java가 class를 실행시킨것. java로 돌아간다. return은 메소드를 한방에 다 벗어난다.
			//break는 괄호 하나만 벗어난다.
		}
		
			
		if(90 <= score) {
			grade = 'A';			
		} else if(score >=80) {
			grade = 'B';			
		} else if(score >=70) {
			grade = 'C';			
		} else if(score >=60) {
			grade = 'D';			
		} else {
			grade = 'F';
		}
		System.out.println("당신의 성적은 " + grade + "입니다."); //system.out은 콘솔(모니터)로 보내느걸 뜻한다 (실행창 이름이 콘솔이징?)

	}

}
