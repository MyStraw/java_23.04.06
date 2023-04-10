package com.ruby.java.ch06;

//하나의 java file에 Student 객체를 정의하고 구현하는 실습
/*
 * 생성자 함수 구현 - this(); 호출 사용
 * static 데이터 멤버 사용
 * static 멤버 함수 구현
 * toString() 함수 구현과 사용
 * 객체 배열 사용
 */
//이건 한화면
public class Student { // 이건 파일 한개로 한 화면에 전부. 아래는 스튜던트 클래스 위로 찢어서.
	static int countStudents;// 객체수
	int sid;// 학번
	String sname; // 학생 이름
	String city; // 주소 도시

	public String toString() {
		return "sid = " + sid + "snmae = " + sname + "city = " + city;
	}

	void showStudent() {
		System.out.print("객체: " + this.toString());
		System.out.println();
	}
//		System.out.print("객체: ");
//		this.toString();
//		System.out.println();
//	}

	public Student() {
		this(0, null, null);
	}

	public Student(int sid) {
		sid = 0;
		sname = null;
		city = null;

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

	static void showNumberObjects() {// 생성된 객체수를 출력한다.
		System.out.println(countStudents);

	}

	// 생성자 구현한다.
	public static void main(String[] args) {

//	 int [] a = new int [5]; // 정수 배열
		Student arry[] = new Student[5]; // 객체 배열. 배열 5개 만들고. 대괄호는 배열.
		showNumberObjects(); // 객체 만드는거. 생성자 함수. 괄호는 함수다.
		arry[0] = new Student(); // 첫번째 배열이 가리키는거.
		arry[1] = new Student(202301);
		arry[2] = new Student(202302, "Hong");
		arry[3] = new Student(202303, "Lee", "Busan");
		arry[4] = new Student(202304, "Na", "jeju");

		Student.showNumberObjects();
	
	 for () {
		 arry[i].showStudent();//생성된 객체 모두를 출력한다.
	 }
	}
}

