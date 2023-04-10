package com.ruby.java.ch06;

public class Member1_1 { // 클래스 이름.

	private String name;
	private int age;

	public Member1_1() { // 함수. 생성자 함수.
		this.name = "guest"; // 뭐 받은게 없으니 일단 게스트라고
		age = 0;
	}

	public Member1_1(String name) {
		this.name = name; // 이름만 넘겨받고 이름만 넘겨받은거.
		age = 0;
	}

	public Member1_1(String name, int age) {
		this.name = name; // 뭐 받은게 없으니 일단 게스트라고, 
		this.age = age; //heap 의 field네

	}

	public void setName(String name) {
	}

	public void show() {//이건 static이 아니니 객체가 있어야 실행. m.show();로 호출을 해야한다.
		//m.show(); 를 메세지라 하고 m을 수신객체라 한다. 
		System.out.println("name = " + name + "age = " + age);
	}
	//위는 스태틱, 아래는 스태틱 아니네.
	

	public static void main(String[] args) { 
		System.out.println("main() 메서드 실행");
		Member1_1 m1 = new Member1_1();
		Member1_1 m2 = new Member1_1("Amy");
		Member1_1 m3 = new Member1_1("Amy",23);
//		new Member1_1(); //member m=new member(); new =>클래스 객체 생성. m=로컬변수.
//		new Member1_1("Amy");
//		new Member1_1("Amy", 23);
		m1.show();
		m2.show();
	}
}
		

