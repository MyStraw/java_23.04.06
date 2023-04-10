package com.ruby.java.ch06;

//하나의 java file에 Student class를 분리하여 정의 구현하는 실습
/*
 * 생성자 함수 구현 - this(); 호출 사용
 * static 데이터 멤버 사용
 * static 멤버 함수 구현
 * toString() 함수 구현과 사용
 * 객체 배열 사용
 */
class Student { // 파일 바깥에 클래스 만들고
	static int countStudents;// 객체수
	int sid;// 학번
	String sname; // 학생 이름
	String city; // 주소 도시


	 public String toString() {
		 return "sid = "+ sid + "snmae = " + sname + "city = " +city;
		 }
	 
	 public void showStudent() {
		 System.out.println(this.toString());
	 
}
	
//	
//	void showStudent() {
//		System.out.print("객체: ");
//		this.toString();
//		System.out.println();
//	}

	static void showNumberObjects() {//생성된 객체수를 출력한다.
		
		 
		
}

	public class TestStudent { // 파일 이름. class는 위로 떼서 해보라

	public static void main(String[] args) {
		Student.countStudents = 0;		 
		 int [] a = new int [5];
		 Student arry[] = new Student[5];
		 Student.showNumberObjects();
		 arry[0] = new Student();
		 arry[1] = new Student(202301);
		 arry[2] = new Student(202302, "Hong");
		 arry[3] = new Student(202303, "Lee", "Busan");
		 arry[4] = new Student(202304, "Na", "jeju");
		 showNumberObjects();
		 
		 for () {
			 arry[i].showStudent();//생성된 객체 모두를 출력한다.
		 }
	 }

	}

}
