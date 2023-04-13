package chapter8.polymorphism;

abstract class Employee { //이게 상속 부모
	String name;
	int salary;

	
	public abstract void calcSalary(); // 앞에 abstract 붙으면 메소드 바디 못가진다.

}