package com.ruby.java.ch06;

public class Member2 {
	private String name;
	private int age;

	public Member2() {
//		this.name = null;
//		this.age = 0;
		this(null); // this 생성자. 1개 부르니까 바로 밑에꺼만 불러

	}

	public Member2(String name) { // 생성자 함수 호출, 2개니까 아래꺼 부른다.
//		this.name = name;
//		this.age = 0;
		this(name, 0);// 생성자 함수로 호출. 생성자 함수가 처음줄에 있어야한다. 264페이지.
		this.age = 0;// 이게 위에꺼보다 윗줄로 가면 빨간줄 뜬다.
	}

	public Member2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void show() { // 멤버함수
//		this("guest");쓰면 에러뜬다. 생성자 함수는 생성자 내에서
	}

	public String toString() {
		return "name = " + /*this.*/name + ", age = " + age; //중간에 왜 this.name 안해? 해도 같다.
	}

	public static void main(String[] args) {
		Member2 m1 = new Member2();
		Member2 m2 = new Member2("Amy");
		Member2 m3 = new Member2("Bobby", 11);
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());

	}
}

//생성자 3개를 만든것. 중복코드. 하드코딩
//name를 pname로 고치려면 일일이 name 찾아서 다 pname으로 고쳐야돼
//Member2_1 파일로 가봐

//괄호면 다 함수. this 가 가리키는게 객체니까 생성자 함수 호출.
