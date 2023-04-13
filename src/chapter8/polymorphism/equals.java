package chapter8.polymorphism;

public class equals {

	public static void main(String[] args) {

		String s1 = new String("abcd");
		String s2 = new String("abcd");

		if (s1 == s2) {
			System.out.println(); //s1과 s2의 객체가 같느냐 묻는것. 다르니 else가 표현됨
		}

		else {
			System.out.println();
		}

		///////////////////////////////////
		
		
		if (s1.equals(s2)) { // s1과 s2가 가진 값이 같느냐? 같다. 이게 표현됨. s1이 s2 오브젝트 오버라이딩 한것. 값이 같아
			System.out.println(); 
		} else {
			System.out.println();
		}
	}
}
