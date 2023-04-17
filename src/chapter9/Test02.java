package chapter9;

import java.util.Arrays;

public class Test02 {

	public static void main(String[] args) {

		String s1 = new String("java");
		String s2 = "java"; // 값은 같은데 객체의
		String s3 = new String("java");
		String s4 = "java";

		System.out.println("s1: " + s1.hashCode() + " s3: " + s3.hashCode());

		if (s1.equals(s3))
			System.out.println("s1 equals s3");
		else
			System.out.println("s1 not equals s3");
		if (s1 == s3)
			System.out.println("s1 == s3");
		else
			System.out.println("같지 않다");

		System.out.println("------------------------------------");
		if (s2.equals(s4))
			System.out.println("s2 equals s4");
		else
			System.out.println("s2 not equals s4");

		if (s2 == s4)
			System.out.println("동일 객체이다.");
		else
			System.out.println("같지 않다");

		System.out.println("------------------------------------");
		if (s1.equals(s2))
			System.out.println("s1 equals s2");
		else
			System.out.println("s1 not equals s2");

		if (s1 == s2)
			System.out.println("동일 객체이다.");
		else
			System.out.println("같지 않다");
		System.out.println("------------------------------------");

		System.out.println(System.identityHashCode(s1) + "::" + System.identityHashCode(s2));// 식별자가다르다
		System.out.println(s1.toString() + "::" + s2.toString());
		System.out.println(s1.hashCode() + "::" + s2.hashCode());
		
		int i3 = Integer.parseInt("123"); //문자열123을 정수 123으로 바꿔준다
		
	}
}
