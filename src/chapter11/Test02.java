package chapter11;

import java.io.FileInputStream;

public class Test02 {
	public static void main(String[] args) {

		try (FileInputStream fi = new FileInputStream("a.txt")) { //546p. try-with-resources 이용하면 fi를 열고 에러나면 catch 하고.. 잉? finally 할핑요 없오?
			/* FileInputStream */ // fi = new FileInputStream("a.txt");
//			System.out.println("1");
//			System.out.println("2");
//			System.out.println("3");
//			String s = null;
//			s.length(); //s가 null이니 오류가나야. 546 파일여는거추가해봐. a.txt 열고 이제 닫는걸
			// finally가 해준다.
		} // try 내에서만 fi랑 s가 작용한다. 그 안에서만 소용이 있다. 밖에선 fi. 적어봐도 아무것도 안떠

		catch (Exception e) {
			System.out.println("오류 발생");
			/*
			 * }finally {//무조건 실행. 에러가 나면 catch. 에러가 안나도 파이널리는 무조건 실행. //fi.close(); //7줄에서
			 * fi를 선언해줌으로서 try 밖에서도 쓸수있게. System.out.println("OK"); // }
			 */
			System.out.println("4");
		}

	}
}
