package com.ruby.java.ch06;

public class Member { //클래스 이름.
	
	private String name;
	private int age;

	public Member() { //함수. 생성자 함수.
		System.out.println("Member() 생성자 실행");
	}

	public Member(String name) {
		System.out.print("Member(String) 생성자 실행 : ");
		System.out.println(name);
	}

	public Member(String name, int age) {
		System.out.print("Member(String, int) 생성자 실행 : ");
		System.out.println(name + " : " + age);
	}

	public void setName(String name) {
	}

	public static void main(String[] args) {
		System.out.println("main() 메서드 실행");
		new Member(); //member m=new member(); new =>클래스 객체 생성. m=로컬변수.
		new Member("Amy");
		new Member("Amy", 23);
	}
}