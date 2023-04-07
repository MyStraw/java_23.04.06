package com.ruby.java.ch06;

// 수업 실습
public class Student4 { // 클래스 생성~ 클래스 이름이랑 파일명이랑 같아야한다.
	private int sid;
	private String name;
	private String dept;
	public Student4() {} // 디폴트 생성자. 아무것도 안줌. 컴파일러가 18, 20번 찍으라 하면
	public Student4(int sid, String name, String dept) {//밑에꺼 먼저 보고 올라와
		this.sid = sid; this.name = name; this.dept = dept; //빨간색은 키워드. 쓰면 안되는 변수 => this 찍으면 0이 아닌 2023//this 없으면 0 나오다가 이거 넣으니 2023.
		//this는 heap의 객체를 가리킨다. this=> receiver object.
	}

	public static void main(String[] args) {
		System.out.println("6장 시작");
		int n = 10; //n 변수선언
		Student4 s = null; //s라는 변수 해주고싶다~ s는 참조변수=레퍼런스. Student4는 클래스. s는 객체를 가리키는 변수. null은 아무것도 안가르켜
		s= new Student4();//null로 default로 아무것도 안주면 컴파일러는 정수는 0, 스트링은 null로 보여준다. 그래서 콘솔 돌리면 0이 나온다. 
		s = new Student4(2023, "홍길동", "컴퓨터"); // ();생성자, 생성함수
		System.out.println(s.sid);
		s.sid=99;
		System.out.println(s.sid);//99로 바뀌네. ->교육용이지 이건 이렇게 사용하지 않는다 실제로. private 만든 이유가 없어. s.sid=99 이런식으로메인에 막 고쳐쓸거같으면.
		System.out.println("student 객체 = " + s); //걍 하니 에러. 
		

	}

}
