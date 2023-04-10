package com.ruby.java.ch06;

public class ThisTest2 {
	private String name;

	public void setName(String name) {
		this.name = name; //this를 여기서 넣어줘야 null이 Amy로 바뀐다.
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		ThisTest2 exam = new ThisTest2();
		exam.setName("Amy"); //변수. 필드() 필드값이 setName의 "Amy"가 되네. 반환 없다.
		System.out.println(exam.getName()); //getName으로 반환된 네임을 받아온다.
	}
}