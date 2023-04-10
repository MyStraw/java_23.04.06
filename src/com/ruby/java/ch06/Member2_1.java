package com.ruby.java.ch06;

public class Member2_1 {
	private String name;
	private int age;

	public Member2_1() {
		this("guest");
	}

	public Member2_1(String name) {
		this(name, 0);
	}

	public Member2_1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public static void main(String[] args) {
		Member2_1 m1 = new Member2_1();
		Member2_1 m2 = new Member2_1("Amy");
		Member2_1 m3 = new Member2_1("Amy", 23);

	}
}
