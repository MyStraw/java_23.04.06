package com.ruby.java.ch06;

//하나의 java file에 Student class를 분리하여 정의 구현하는 실습
/*
* 생성자 함수 구현 - this(); 호출 사용
* static 데이터 멤버 사용
* static 멤버 함수 구현
* toString() 함수 구현과 사용
* 객체 배열 사용
*/
class Student {
	static int countStudents;
	int sid;
	String sname;
	String city;

	public Student() {
		this(0, null, null);
	}

	public Student(int sid) {
		this(sid, null, null);
	}

	public Student(int sid, String sname) {
		this(sid, sname, null);
	}

	public Student(int sid, String sname, String city) {
		this.sid = sid;
		this.sname = sname;
		this.city = city;
		countStudents++;
	}

	public String toString() {
		return "sid = " + sid + " sname = " + sname + " city = " + city;
	}

	void showStudent() {
		System.out.println(this.toString()); // 위에 선언한 메소드. 리턴받은 값을 다 적는다. 다만 아무것도 대입 안됐으니 0, null, null만 나오겄지.
	}

	static void showNumberObjects() {
		System.out.println("객체 수: " + countStudents);
	}

}

public class TestStudent { // 파일 이름. class는 위로 떼서 해보라

	public static void main(String[] args) {
		Student[] array = new Student[5];
		array[0] = new Student();
		array[1] = new Student(202301);
		array[2] = new Student(202302, "Hong");
		array[3] = new Student(202303, "Lee", "Busan");
		array[4] = new Student(202304, "Na", "Jeju");
		Student.showNumberObjects();

		for (int i = 0; i < 5; i++) {
			array[i].showStudent();
		}

	}

}