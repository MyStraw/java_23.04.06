package chapter8.polymorphism;

import java.util.Iterator;

public class HTSTest {
	public static void calcTax(Employee e) {
		System.out.println("소득세를 게산합니다.");
	}

///////////////////////////////////////////////////////////////////////////////
//	public static void main (String[] args) {
//		Salesman s = new Salesman();
//		Consultant c = new Consultant();
//		Director d = new Director();
//		
////		calcTax(s);
////		calcTax(c);
////		calcTax(d);		
//		
//		System.out.println(s.toString());
//		System.out.println(c.toString());
//		System.out.println(d.toString());
//		
//		Salesman s2 = s; //341p. 둘다 스택에 따로따로
//		System.out.println(s2.toString());
//		
//		if(s.equals(s2)) { //할당 연산자 통해 s 값을 s2에 그대로 넣어줬다. 똑같은 객체를 가리키는 참조변수. 이 둘의 해쉬코드는 같다. object 메소드 목록보면 equals가 있다. 객체주소는 해쉬태그로 되어있는데 이 둘이 같은지 보는것.
//			System.out.println("동일한 객체입니다.");
//			
//		} else {
//			System.out.println("서로 다른 객체입니다.");
//		}
/////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {

		Salesman s1 = new Salesman();
		Consultant s2 = new Consultant();
		Director s3 = new Director();

		Object m1 = new Manager();
		Employee m2 = new Manager();
		Manager m3 = new Manager();
		// Director m4 = new Manager(); // 오류발생 //왼쪽이 무조건 부모. 받는쪽이 부모.

		// 부모는 자식을 품을수있다. 대신 자식은 부모를 못품지.

		Object arr[] = new Object[6];
		arr[0] = s1;
		arr[1] = s2;
		arr[2] = s3;
		arr[3] = m1;
		arr[4] = m2;
		arr[5] = m3;

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}
}
